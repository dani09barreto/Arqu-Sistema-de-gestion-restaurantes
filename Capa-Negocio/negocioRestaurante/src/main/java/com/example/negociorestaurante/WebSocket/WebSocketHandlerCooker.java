package com.example.negociorestaurante.WebSocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WebSocketHandlerCooker extends TextWebSocketHandler {
    private static final Set<WebSocketSession> sessions = new HashSet<>();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
        System.out.println("Nueva conexión: " + session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
    }

    public static void enviarActualizacion(Object objeto) {
        String json;
        try {
            json = objectMapper.writeValueAsString(objeto);
            for (WebSocketSession session : sessions) {
                session.sendMessage(new TextMessage(json));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
