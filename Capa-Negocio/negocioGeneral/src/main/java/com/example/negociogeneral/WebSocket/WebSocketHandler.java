package com.example.negociogeneral.WebSocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private static final Set<WebSocketSession> sessions = new HashSet<>();
    private static final Set<Object> objetosCola = new HashSet<>();
    private static final Gson gson = new Gson();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
        if (!objetosCola.isEmpty()) {
            System.out.println("Hay objetos en la cola, se envían");
            for (Object objeto : objetosCola) {
                enviarActualizacion(objeto);
            }
            objetosCola.clear();
        }
        System.out.println("Nueva conexión: " + session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
    }

    public static void enviarActualizacion(Object objeto) {
        String json;
        try {
            if (sessions.isEmpty()) {
                System.out.println("No hay sesiones activas, se agrega a la cola");
                objetosCola.add(objeto);
                return;
            }
            json = gson.toJson(objeto);
            for (WebSocketSession session : sessions) {
                session.sendMessage(new TextMessage(json));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
