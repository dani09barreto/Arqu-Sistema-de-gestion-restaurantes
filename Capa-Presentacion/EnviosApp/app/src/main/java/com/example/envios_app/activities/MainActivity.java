package com.example.envios_app.activities;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.envios_app.R;
import com.example.envios_app.REST.IDespachadorService;
import com.example.envios_app.adapters.EnvioInventarioAdapter;
import com.example.envios_app.databinding.ActivityMainBinding;
import com.example.envios_app.model.DestServer;
import com.example.envios_app.model.EnvioInventario;
import com.example.envios_app.model.ServicesRoutes;
import com.example.envios_app.utils.PermissionHelper;
import com.example.envios_app.utils.ResponseLB;
import com.example.envios_app.utils.RetrofitClient;
import com.example.envios_app.webSocket.WebSocketClientImpl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AuthenticatedActivity {

    private ActivityMainBinding binding;
    private WebSocketClientImpl webSocketClient;
    private IDespachadorService despachadorService;
    private List<EnvioInventario> enviosInventario = new ArrayList<>();
    private EnvioInventarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new EnvioInventarioAdapter(this, R.id.listViewEnvioInventario, enviosInventario);

        if (isAuthenticated()){
            if (!existeDestinoGeneral()){
                getUrlDespachador();
            }
        }

        binding.button.setOnClickListener(v -> {
            loadingDialog.show();
            getUrlGeneral();
        });

        binding.listViewEnvioInventario.setAdapter(adapter);
    }

    private void getUrlGeneral(){
        responseLB.getResponse(getDestinoGeneral(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                conectarWebSocket(headerValue);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
    }

    private void conectarWebSocket(String ipGeneral) {

        String token = getTokenUser();
        try {
            webSocketClient = new WebSocketClientImpl(ServicesRoutes.getServerGeneralWebSocket(ipGeneral), token, binding, loadingDialog, this, alertsHelper, enviosInventario, adapter);
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

    protected void getUrlDespachador() {
        responseLB.getResponse(ServicesRoutes.getUrlLbDespachador(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                getUrlLBGeneal(ServicesRoutes.getServerDespachador(headerValue));
            }

            @Override
            public void onError(String errorMessage) {
                alertsHelper.shortToast(getApplicationContext(), errorMessage);
            }
        });
    }

    protected void getUrlLBGeneal(String serverDespachador) {
        despachadorService = RetrofitClient.getRetrofitInstance(serverDespachador).create(IDespachadorService.class);

        Call<DestServer> call = despachadorService.obtenerDestino(ServicesRoutes.getDestinoGeneral());
        call.enqueue(new Callback<DestServer>() {
            @Override
            public void onResponse(Call<DestServer> call, Response<DestServer> response) {
                if (response.isSuccessful()){
                    runOnUiThread(() -> {
                        DestServer destServer = response.body();
                        if (destServer != null) {
                            SharedPreferences sharedPref = getSharedPreferences("session", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("direccionGeneral", destServer.getDireccion());
                            editor.apply();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<DestServer> call, Throwable t) {
                alertsHelper.shortToast(getApplicationContext(), t.getMessage());
            }
        });
    }
}