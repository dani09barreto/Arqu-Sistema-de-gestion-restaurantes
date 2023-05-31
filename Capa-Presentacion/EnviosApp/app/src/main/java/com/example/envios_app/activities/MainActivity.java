package com.example.envios_app.activities;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.envios_app.R;
import com.example.envios_app.REST.IDespachadorService;
import com.example.envios_app.REST.IInventarioService;
import com.example.envios_app.adapters.EnvioInventarioAdapter;
import com.example.envios_app.databinding.ActivityMainBinding;
import com.example.envios_app.model.DestServer;
import com.example.envios_app.model.EnvioInventario;
import com.example.envios_app.model.EnvioSolicitudInventario;
import com.example.envios_app.model.Mensaje;
import com.example.envios_app.model.ServicesRoutes;
import com.example.envios_app.utils.PermissionHelper;
import com.example.envios_app.utils.ResponseLB;
import com.example.envios_app.utils.RetrofitClient;
import com.example.envios_app.webSocket.WebSocketClientEnvios;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AuthenticatedActivity {

    private ActivityMainBinding binding;
    private WebSocketClientEnvios webSocketClient;
    private List<EnvioSolicitudInventario> enviosInventario = new ArrayList<>();
    private EnvioInventarioAdapter adapter;
    private IInventarioService inventarioService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new EnvioInventarioAdapter(this, R.id.listViewEnvioInventario, enviosInventario, this);

        if (isAuthenticated()){
            if (!existeDestinoGeneral()){
                getUrlDespachador();
            }
        }

        binding.button.setOnClickListener(v -> {
            loadingDialog.show();
            getUrlGeneral(null);
        });

        binding.listViewEnvioInventario.setAdapter(adapter);
    }

    public void getUrlGeneral(EnvioSolicitudInventario en){
        responseLB.getResponse(getDestinoGeneral(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                if (en == null){
                    conectarWebSocket(headerValue);
                    return;
                }
                cambiarEstadoEnvio(headerValue, en);
            }
            @Override
            public void onError(String errorMessage) {

            }
        });
    }

    private void cambiarEstadoEnvio(String ipGeneral, EnvioSolicitudInventario en) {
        String token = getTokenUser();
        loadingDialog.show();
        inventarioService = RetrofitClient.getRetrofitInstance(ServicesRoutes.getServerGeneral(ipGeneral), token).create(IInventarioService.class);

        Call <Mensaje> call = inventarioService.cambiarEstado(en.getEnvioInventario().getId(), "En_Camino");
        call.enqueue(new Callback<Mensaje>() {
            @Override
            public void onResponse(Call<Mensaje> call, Response<Mensaje> response) {
                if (!response.isSuccessful()){
                    alertsHelper.shortToast(getApplicationContext(), "Error al cambiar el estado del pedido intentelo de nuevo");
                    loadingDialog.dismiss();
                    return;
                }
                loadingDialog.dismiss();
                alertsHelper.shortToast(getApplicationContext(), String.format("Se asigno el pedido a %s", en.getEnvioInventario().getUsuario().getNombre()));
                Intent intent = new Intent(MainActivity.this , MapActivity.class);
                intent.putExtra("ENVIO_INVENTARIO", en);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Mensaje> call, Throwable t) {
                alertsHelper.shortToast(getApplicationContext(), "Error al cambiar el estado del pedido");
                loadingDialog.dismiss();
            }
        });
    }

    private void conectarWebSocket(String ipGeneral) {

        String token = getTokenUser();
        try {
            webSocketClient = new WebSocketClientEnvios(ServicesRoutes.getServerGeneralWebSocketEnvios(ipGeneral), token, binding, loadingDialog, this, alertsHelper, enviosInventario, adapter);
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

    @Override
    protected void onStart() {
        super.onStart();
        permissionHelper.getLocationPermission(this);
        if (permissionHelper.isMLocationPermissionGranted()) {
            locationService.startLocation();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PermissionHelper.PERMISSIONS_LOCATION) {
            permissionHelper.getLocationPermission(this);
            if (permissionHelper.isMLocationPermissionGranted()) {
                locationService.startLocation();
            }
        }
    }
}