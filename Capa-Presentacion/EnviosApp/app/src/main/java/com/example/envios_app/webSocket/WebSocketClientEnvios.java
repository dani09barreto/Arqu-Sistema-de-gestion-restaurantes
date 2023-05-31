package com.example.envios_app.webSocket;

import android.app.Activity;

import com.example.envios_app.activities.MainActivity;
import com.example.envios_app.activities.dialog.LoadingDialog;
import com.example.envios_app.adapters.EnvioInventarioAdapter;
import com.example.envios_app.databinding.ActivityMainBinding;
import com.example.envios_app.model.EnvioInventario;
import com.example.envios_app.model.EnvioSolicitudInventario;
import com.example.envios_app.utils.AlertsHelper;
import com.example.envios_app.utils.CustomDateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WebSocketClientEnvios extends WebSocketClient {

    private List <EnvioSolicitudInventario> enviosInventario;

    private EnvioInventarioAdapter adapter;
    private ActivityMainBinding binding;
    private Activity activity;

    private LoadingDialog loadingDialog;

    private AlertsHelper alertsHelper;

    private static final String ESTADO_ENVIO = "En_Camino";

    private Gson gson;

    public WebSocketClientEnvios(String serverUrl, String token, ActivityMainBinding binding, LoadingDialog loadingDialog, Activity activity, AlertsHelper alertsHelper, List <EnvioSolicitudInventario> enviosInventario, EnvioInventarioAdapter adapter) throws URISyntaxException {
        super(new URI(serverUrl), new Draft_6455(), createHeaders(token));
        this.binding = binding;
        this.loadingDialog = loadingDialog;
        this.activity = activity;
        this.alertsHelper = alertsHelper;
        this.enviosInventario = enviosInventario;
        this.adapter = adapter;
        gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new CustomDateDeserializer())
                .create();
    }

    private static Map<String, String> createHeaders(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        return headers;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        activity.runOnUiThread(() -> {
            alertsHelper.shortToast(activity.getApplicationContext(), "Conexion realizada");
            loadingDialog.dismissDialog();
        });
    }

    @Override
    public void onMessage(String message) {
        System.out.println("message received: " + message);
        activity.runOnUiThread(() -> {
             EnvioSolicitudInventario solicitudInventario = gson.fromJson(message, EnvioSolicitudInventario.class);
             if(pedidoAsignado(solicitudInventario.getEnvioInventario()) != null){
                 enviosInventario.remove(pedidoAsignado(solicitudInventario.getEnvioInventario()));
             }else{
                 enviosInventario.add(solicitudInventario);
             }
             adapter.notifyDataSetChanged();
             binding.listViewEnvioInventario.post(() -> binding.listViewEnvioInventario.setSelection(enviosInventario.size() - 1));
        });
    }

    private EnvioSolicitudInventario pedidoAsignado(EnvioInventario envioInventario) {
        for (EnvioSolicitudInventario envioSolicitudInventario : enviosInventario){
            if(envioSolicitudInventario.getEnvioInventario().getId().equals(envioInventario.getId())){
                if (envioInventario.getEstadoEnvio().getEstado().equals(ESTADO_ENVIO)){
                    return envioSolicitudInventario;
                }
            }
        }
        return null;
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        if (hasStatusCode401(reason)){
            activity.runOnUiThread(() -> {
                alertsHelper.shortToast(activity.getApplicationContext(), "Sesion expirada");
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.signOut();
                loadingDialog.dismissDialog();
            });
        }
        activity.runOnUiThread(() -> {
            alertsHelper.shortToast(activity.getApplicationContext(), "closed with exit code " + code + " additional info: " + reason);
            loadingDialog.dismissDialog();
        });
    }

    public boolean hasStatusCode401(String message) {
        return message.contains("401");
    }

    @Override
    public void onError(Exception ex) {
        System.out.println("an error occurred:" + ex);
        activity.runOnUiThread(() -> {
            alertsHelper.shortToast(activity.getApplicationContext(), "an error occurred:" + ex);
            loadingDialog.dismissDialog();
        });
    }

}
