package com.example.envios_app.webSocket;

import android.content.Context;

import com.example.envios_app.utils.AlertsHelper;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class WebSocketClientImpl extends WebSocketClient {

    public WebSocketClientImpl(String serverUrl, String token) throws URISyntaxException {
        super(new URI(serverUrl), new Draft_6455(), createHeaders(token));
    }

    private static Map<String, String> createHeaders(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        return headers;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("new connection opened");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("message received: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("closed with exit code " + code + " additional info: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        System.out.println("an error occurred:" + ex);
    }

}
