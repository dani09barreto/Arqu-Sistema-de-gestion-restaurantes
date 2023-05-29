package com.example.negociogeneral.Mensajeria;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {
    @RabbitListener(queues = "queue-position")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}

