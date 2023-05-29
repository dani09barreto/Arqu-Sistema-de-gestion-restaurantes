package com.example.envios_app.webSocket;


import android.app.Activity;

import com.example.envios_app.utils.AlertsHelper;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class WebSocketClientPos extends WebSocketClient {

    private AlertsHelper alertsHelper;
    private Activity activity;

    public WebSocketClientPos(String serverUrl, String token, AlertsHelper alertsHelper, Activity activity) throws URISyntaxException {
        super(new URI(serverUrl), new Draft_6455(), createHeaders(token));
        this.alertsHelper = alertsHelper;
        this.activity = activity;
    }

    private static Map<String, String> createHeaders(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        return headers;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        activity.runOnUiThread(() -> alertsHelper.shortToast(activity.getApplicationContext(), "Conexion realizada"));
    }

    @Override
    public void onMessage(String message) {
        System.out.println("onMessage");
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("onClose");
    }

    @Override
    public void onError(Exception ex) {
        System.out.println("onError");
    }
}
