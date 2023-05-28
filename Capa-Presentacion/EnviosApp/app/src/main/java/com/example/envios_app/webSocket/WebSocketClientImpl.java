package com.example.envios_app.webSocket;

import android.app.Activity;
import android.content.Context;

import com.example.envios_app.R;
import com.example.envios_app.activities.MainActivity;
import com.example.envios_app.activities.dialog.LoadingDialog;
import com.example.envios_app.adapters.EnvioInventarioAdapter;
import com.example.envios_app.databinding.ActivityMainBinding;
import com.example.envios_app.model.EnvioInventario;
import com.example.envios_app.utils.AlertsHelper;
import com.example.envios_app.utils.CustomDateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebSocketClientImpl extends WebSocketClient {

    private List <EnvioInventario> enviosInventario;

    private EnvioInventarioAdapter adapter;
    private ActivityMainBinding binding;
    private Activity activity;

    private LoadingDialog loadingDialog;

    private AlertsHelper alertsHelper;

    private Gson gson;

    public WebSocketClientImpl(String serverUrl, String token, ActivityMainBinding binding, LoadingDialog loadingDialog, Activity activity, AlertsHelper alertsHelper, List <EnvioInventario> enviosInventario, EnvioInventarioAdapter adapter) throws URISyntaxException {
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
            EnvioInventario envioInventario = gson.fromJson(message, EnvioInventario.class);
            enviosInventario.add(envioInventario);
            adapter.notifyDataSetChanged();
            binding.listViewEnvioInventario.post(() -> binding.listViewEnvioInventario.setSelection(enviosInventario.size() - 1));
        });
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("closed with exit code " + code + " additional info: " + reason);
        if (code == 401){
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

    @Override
    public void onError(Exception ex) {
        System.out.println("an error occurred:" + ex);
        activity.runOnUiThread(() -> {
            alertsHelper.shortToast(activity.getApplicationContext(), "an error occurred:" + ex);
            loadingDialog.dismissDialog();
        });
    }

}
