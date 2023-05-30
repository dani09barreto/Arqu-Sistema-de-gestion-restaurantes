package com.example.envios_app.activities;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;

import com.example.envios_app.databinding.ActivityMapBinding;
import com.example.envios_app.model.EnvioInventario;
import com.example.envios_app.model.PosicionPedido;
import com.example.envios_app.model.ServicesRoutes;
import com.example.envios_app.utils.ResponseLB;
import com.example.envios_app.webSocket.WebSocketClientPos;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.gson.Gson;

import java.net.URISyntaxException;

public class MapActivity extends AuthenticatedActivity {

    private ActivityMapBinding binding;
    private WebSocketClientPos webSocketClient;

    private final Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MapsFragment mapsFragment = binding.fragmentContainerView.getFragment();
        Intent intent = getIntent();
        EnvioInventario envioInventario = (EnvioInventario) intent.getSerializableExtra("ENVIO_INVENTARIO");

        mapsFragment.setEnvioInventario(envioInventario);

        if (!existeDestinoGeneral()){
            getUrlDespachador();
        }

        locationService.setLocationCallback(new LocationCallback() {
            @Override
            public void onLocationAvailability(@NonNull LocationAvailability locationAvailability) {
                super.onLocationAvailability(locationAvailability);
            }

            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                super.onLocationResult(locationResult);
                mapsFragment.updateLocation(locationResult.getLastLocation());
                if (existeDestinoGeneral()){
                    if (webSocketClient == null){
                        getUrlGeneral();
                    }else if (webSocketClient.isOpen()){
                        enviarPosPedido(locationResult, envioInventario.getId());
                    }
                }
            }
        });

    }

    public void getUrlGeneral(){
        responseLB.getResponse(getDestinoGeneral(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                conectarWebSocketPos(headerValue);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
    }

    private void enviarPosPedido(LocationResult locationResult, Long id) {
        PosicionPedido pos = new PosicionPedido(id, locationResult.getLastLocation().getLatitude(), locationResult.getLastLocation().getLongitude());
        webSocketClient.send(gson.toJson(pos));
    }

    private void conectarWebSocketPos(String ipGeneral) {

        String token = getTokenUser();
        try {
            webSocketClient = new WebSocketClientPos(ServicesRoutes.getServerGeneralWebSocketPos(ipGeneral), token, alertsHelper, this);
            webSocketClient.connect();
        } catch (URISyntaxException e) {
            alertsHelper.shortToast(getApplicationContext(), "Error al conectar con el servidor");
        }
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webSocketClient != null && webSocketClient.isOpen()) {
            webSocketClient.close();
        }
    }
}