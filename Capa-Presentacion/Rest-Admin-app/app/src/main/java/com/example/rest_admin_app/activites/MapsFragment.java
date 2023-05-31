package com.example.rest_admin_app.activites;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rest_admin_app.App;
import com.example.rest_admin_app.R;
import com.example.rest_admin_app.databinding.FragmentMapsBinding;
import com.example.rest_admin_app.model.SolicitudInventario;
import com.example.rest_admin_app.utils.AlertsHelper;
import com.example.rest_admin_app.webSocket.WebSocketEnvio;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import javax.inject.Inject;

public class MapsFragment extends Fragment {

    GoogleMap googleMap;
    private FragmentMapsBinding binding;
    static final int INITIAL_ZOOM_LEVEL = 18;
    private boolean init = false;
    @Inject
    AlertsHelper alertsHelper;


    private WebSocketEnvio webSocketClient;
    private SolicitudInventario solicitudInventario;

    private LatLng actualPosition;
    private String token;

    public void setToken(String token) {
        this.token = token;
    }


    public void setSolicitudInventario(SolicitudInventario solicitudInventario) {
        this.solicitudInventario = solicitudInventario;
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
        }
    };

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
                centrarCamara(new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude()));
            }
            actualPosition = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
        }
        binding.buttonCentrar.setOnClickListener(v -> {
            centrarCamara(new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude()));
        });
    }

    private void centrarCamara(LatLng pos) {
        LatLng latLng = new LatLng(pos.latitude, pos.longitude);
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(INITIAL_ZOOM_LEVEL));
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
    }
}