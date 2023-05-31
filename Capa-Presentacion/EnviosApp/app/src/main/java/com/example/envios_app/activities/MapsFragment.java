package com.example.envios_app.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.envios_app.App;
import com.example.envios_app.R;
import com.example.envios_app.activities.dialog.InfoBodegaDialog;
import com.example.envios_app.activities.dialog.InfoRestauranteDialog;
import com.example.envios_app.databinding.FragmentMapsBinding;
import com.example.envios_app.model.EnvioSolicitudInventario;
import com.example.envios_app.utils.AlertsHelper;
import com.example.envios_app.utils.BitmapUtils;
import com.example.envios_app.utils.DistanceUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MapsFragment extends Fragment {

    private GoogleMap googleMap;
    private FragmentMapsBinding binding;
    static final int INITIAL_ZOOM_LEVEL = 18;
    private boolean init = false;
    private EnvioSolicitudInventario envioInventario;
    private LatLng actualPosition;
    private List <Marker> markers = new ArrayList<>();

    @Inject
    AlertsHelper alertsHelper;

    public void setEnvioInventario(EnvioSolicitudInventario envioInventario) {
        this.envioInventario = envioInventario;
    }

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @SuppressLint("MissingPermission")
        @Override
        public void onMapReady(GoogleMap Map) {
            googleMap = Map;
            googleMap.moveCamera(CameraUpdateFactory.zoomTo(INITIAL_ZOOM_LEVEL));
            googleMap.getUiSettings().setAllGesturesEnabled(true);
            googleMap.getUiSettings().setZoomGesturesEnabled(true);
            googleMap.setMyLocationEnabled(true);
            googleMap.setOnMarkerClickListener(markerClickListener);
        }
    };
    private GoogleMap.OnMarkerClickListener markerClickListener = new GoogleMap.OnMarkerClickListener() {
        @SuppressLint({"DefaultLocale", "SetTextI18n"})
        @Override
        public boolean onMarkerClick(@NonNull Marker marker) {
            if (esBodega(marker.getPosition())){
                InfoBodegaDialog dialog = new InfoBodegaDialog(getContext());
                dialog.getBinding().textViewPedido.setText(String.format("Pedido %d", envioInventario.getEnvioInventario().getId()));
                dialog.getBinding().textBodega.setText(envioInventario.getEnvioInventario().getBodega().getNombre());
                dialog.getBinding().textDireccionBodega.setText(envioInventario.getEnvioInventario().getBodega().getDireccion());
                double distancia = DistanceUtils.calculateDistanceInKilometer(marker.getPosition().latitude, marker.getPosition().longitude, actualPosition.latitude, actualPosition.longitude);
                dialog.getBinding().textDistancia.setText(String.format("Distancia %.2f", distancia) + " km");
                dialog.show();
                dialog.getBinding().buttonRecoger.setOnClickListener(v -> {
                    if (!verificarDistancia(distancia)){
                        alertsHelper.shortToast(getContext(), "Aun no se encuentra en la bodega");
                    }else{
                        removeMarkers();
                        generateMarkerRest();
                    }
                });
                dialog.getBinding().buttonIr.setOnClickListener(v -> {
                    LatLng pos = new LatLng(envioInventario.getEnvioInventario().getBodega().getLat(), envioInventario.getEnvioInventario().getBodega().getLng());
                    createIntentIr(pos);
                });
            }else{
                InfoRestauranteDialog dialog = new InfoRestauranteDialog(getContext());
                dialog.getBinding().textViewPedido.setText(String.format("Pedido %d", envioInventario.getEnvioInventario().getId()));
                dialog.getBinding().textRestaurante.setText(envioInventario.getEnvioInventario().getRestaurante().getNombre());
                dialog.getBinding().textDireccionRestaurante.setText(envioInventario.getEnvioInventario().getRestaurante().getDireccion());
                double distancia = DistanceUtils.calculateDistanceInKilometer(marker.getPosition().latitude, marker.getPosition().longitude, actualPosition.latitude, actualPosition.longitude);
                dialog.getBinding().textDistancia.setText(String.format("Distancia %.2f", distancia) + " km");
                dialog.show();
                dialog.getBinding().buttonEntregar.setOnClickListener(v -> {
                    if (!verificarDistancia(distancia)){
                        alertsHelper.shortToast(getContext(), "Aun no se encuentra en el restaurante");
                    }
                });
                dialog.getBinding().buttonIr.setOnClickListener(v -> {
                    LatLng pos = new LatLng(envioInventario.getEnvioInventario().getRestaurante().getLat(), envioInventario.getEnvioInventario().getRestaurante().getLng());
                    createIntentIr(pos);
                });
            }
            return false;
        }
    };

    private void removeMarkers() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            markers.forEach(marker -> marker.remove());
            markers.clear();
        }
    }

    private boolean verificarDistancia(double distancia) {
        if (distancia <= 0.4){
            return true;
        }
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ((App) requireActivity().getApplicationContext()).getAppComponent().inject(this);
        binding = FragmentMapsBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }


    public void updateLocation(Location lastLocation) {
        if (googleMap != null) {
            if (!init){
                init = true;
                generateMarkerBodega();
                centrarCamara(new LatLng(envioInventario.getEnvioInventario().getBodega().getLat(), envioInventario.getEnvioInventario().getBodega().getLng()));
            }
            actualPosition = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
        }
        binding.buttonCentrar.setOnClickListener(v -> {
            centrarCamara(new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude()));
        });
    }

    private void generateMarkerRest(){
        LatLng posRest = new LatLng(envioInventario.getEnvioInventario().getRestaurante().getLat(), envioInventario.getEnvioInventario().getRestaurante().getLng());

        Marker markerTemp = googleMap.addMarker(new MarkerOptions()
                .position(posRest)
                .title(envioInventario.getEnvioInventario().getRestaurante().getNombre())
                .snippet(envioInventario.getEnvioInventario().getRestaurante().getDireccion())
                .icon(BitmapUtils.getBitmapDescriptor(getContext(), R.drawable.baseline_fastfood_24))
        );
        markers.add(markerTemp);
    }

    private void generateMarkerBodega() {
        LatLng posBodega = new LatLng(envioInventario.getEnvioInventario().getBodega().getLat(), envioInventario.getEnvioInventario().getBodega().getLng());

        Marker markerTemp = googleMap.addMarker(new MarkerOptions()
                .position(posBodega)
                .title(envioInventario.getEnvioInventario().getBodega().getNombre())
                .snippet(envioInventario.getEnvioInventario().getBodega().getDireccion())
                .icon(BitmapUtils.getBitmapDescriptor(getContext(), R.drawable.baseline_home_work_24))
        );
        markers.add(markerTemp);
    }

    private void centrarCamara(LatLng pos) {
        LatLng latLng = new LatLng(pos.latitude, pos.longitude);
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(INITIAL_ZOOM_LEVEL));
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    private boolean esBodega(LatLng location){
        LatLng posBodega = new LatLng(envioInventario.getEnvioInventario().getBodega().getLat(), envioInventario.getEnvioInventario().getBodega().getLng());
        LatLng pos = new LatLng(location.latitude, location.longitude);
        return posBodega.equals(pos);
    }

    @SuppressLint("DefaultLocale")
    private void createIntentIr(LatLng pos){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(String.format("geo:0,0?q=%f,%f", pos.latitude, pos.longitude)));
        Intent chooser = Intent.createChooser(intent, "Selecciona una aplicación de navegación");
        startActivity(chooser);
    }
}