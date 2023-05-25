package com.example.envios_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.envios_app.R;
import com.example.envios_app.databinding.ActivityLoginBinding;
import com.example.envios_app.databinding.ActivityMainBinding;
import com.example.envios_app.webSocket.WebSocketClientImpl;

import java.net.URISyntaxException;

public class MainActivity extends AuthenticatedActivity {

    private ActivityMainBinding binding;
    private WebSocketClientImpl webSocketClient;
    public static final String serverUrl = "ws://172.20.10.4:8190/websocket-path";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", null);
        try {
            webSocketClient = new WebSocketClientImpl(serverUrl, token, binding, this);
            webSocketClient.connect();
        } catch (URISyntaxException e) {
            alertsHelper.shortToast(getApplicationContext(), "Error al conectar con el servidor");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        alertsHelper.shortToast(getApplicationContext(), "onDestroy");
        if (webSocketClient != null && webSocketClient.isOpen()) {
            webSocketClient.close();
        }
    }
}