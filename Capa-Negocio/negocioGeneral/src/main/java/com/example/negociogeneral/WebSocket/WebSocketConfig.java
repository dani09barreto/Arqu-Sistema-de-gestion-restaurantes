package com.example.negociogeneral.WebSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketHandler webSocketHandler;
    private final MobileWebSocketHandler mobileWebSocketHandler;
    private final OrderWebSocketHandler orderWebSocketHandler;

    public WebSocketConfig(WebSocketHandler webSocketHandler, MobileWebSocketHandler mobileWebSocketHandler, OrderWebSocketHandler orderWebSocketHandler) {
        this.webSocketHandler = webSocketHandler;
        this.mobileWebSocketHandler = mobileWebSocketHandler;
        this.orderWebSocketHandler = orderWebSocketHandler;
    }
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebSocketHandler(), "/websocket-path").setAllowedOrigins("*");
        registry.addHandler(new MobileWebSocketHandler(), "/mobile-websocket-path").setAllowedOrigins("*");
        registry.addHandler(new OrderWebSocketHandler(), "/order-websocket-path").setAllowedOrigins("*");
    }
}
