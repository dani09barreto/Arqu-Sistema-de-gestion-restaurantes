package com.example.rest_admin_app.webSocket;

import android.app.Activity;

import com.example.rest_admin_app.R;
import com.example.rest_admin_app.model.PosicionPedido;
import com.example.rest_admin_app.utils.AlertsHelper;
import com.example.rest_admin_app.utils.BitmapUtils;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class WebSocketEnvio extends WebSocketClient {
    private Activity activity;
    private AlertsHelper alertsHelper;
    private GoogleMap googleMap;
    private Marker delivery;
    private final Gson gson = new Gson();

    public WebSocketEnvio(String serverUri, String token, Activity activity, AlertsHelper alertsHelper, GoogleMap googleMap) throws URISyntaxException {
        super(new URI(serverUri), new Draft_6455(), createHeaders(token));
        this.activity = activity;
        this.alertsHelper = alertsHelper;
        this.googleMap = googleMap;
    }

    private static Map<String, String> createHeaders(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        return headers;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Conexión abierta");
    }

    @Override
    public void onMessage(String message) {
        activity.runOnUiThread(() -> {
            PosicionPedido posPedido = gson.fromJson(message, PosicionPedido.class);
            LatLng pos = new LatLng(posPedido.getLat(), posPedido.getLng());
            if (delivery == null){
                delivery = googleMap.addMarker(new MarkerOptions()
                        .title("Domiciliario")
                        .position(pos)
                        .icon(BitmapUtils.getBitmapDescriptor(activity.getApplication().getApplicationContext(), R.drawable.baseline_delivery_dining_24))
                );
            }
            else{
                delivery.setPosition(pos);
            }
        });
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Conexión cerrada");
    }

    @Override
    public void onError(Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
