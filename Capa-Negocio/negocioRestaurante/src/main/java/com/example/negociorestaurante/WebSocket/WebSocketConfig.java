package com.example.negociorestaurante.WebSocket;

import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebSocketHandlerCooker(), "/websocket-path").setAllowedOrigins("*");
        registry.addHandler(new WebSocketHandlerClient(),"/websocketClient-path").setAllowedOrigins("*");
    }
}
