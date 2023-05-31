package com.example.rest_admin_app.activites;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.rest_admin_app.databinding.ActivityMapaBinding;
import com.example.rest_admin_app.model.Mensaje;
import com.example.rest_admin_app.model.ServicesRoutes;
import com.example.rest_admin_app.model.SolicitudInventario;
import com.example.rest_admin_app.webSocket.WebSocketEnvio;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.gson.Gson;

import java.net.URISyntaxException;

public class MapaActivity extends AuthenticatedActivity {

    private ActivityMapaBinding binding;
    private WebSocketEnvio webSocketClient;
    MapsFragment mapsFragment;
    private SolicitudInventario solicitudInventario;
    private final Gson gson = new Gson();
    private boolean enviado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mapsFragment = binding.fragmentContainerView.getFragment();
        Intent intent = getIntent();
        solicitudInventario = (SolicitudInventario) intent.getSerializableExtra("ENVIO_INVENTARIO");
        mapsFragment.setSolicitudInventario(solicitudInventario);
        mapsFragment.setToken(getTokenUser());

        locationService.setLocationCallback(new LocationCallback() {
            @Override
            public void onLocationAvailability(@NonNull LocationAvailability locationAvailability) {
                super.onLocationAvailability(locationAvailability);
            }

            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                super.onLocationResult(locationResult);
                mapsFragment.updateLocation(locationResult.getLastLocation());
                if (mapsFragment.googleMap != null){
                    if (webSocketClient == null) {
                        conectarWebSocket();
                    }else if (!enviado){
                        enviado = true;
                        webSocketClient.send(gson.toJson(new Mensaje(getIdPedido())));
                    }
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!permissionHelper.isMLocationPermissionGranted()){
            alertsHelper.shortToast(getApplicationContext(), "No se han concedido los permisos de ubicación");
            finish();
        }
        locationService.startLocation();
    }

    private void conectarWebSocket() {
        try {
            webSocketClient = new WebSocketEnvio(ServicesRoutes.getServerGeneralWebSocketOrder(solicitudInventario.getUri()), getTokenUser(), this, alertsHelper, mapsFragment.googleMap);
            String idPedido = getIdPedido();
            webSocketClient.connect();
        } catch (URISyntaxException e) {
            alertsHelper.shortToast(getApplicationContext(), "Error al conectar con el servidor");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webSocketClient != null && webSocketClient.isOpen()) {
            webSocketClient.close();
        }
    }
}