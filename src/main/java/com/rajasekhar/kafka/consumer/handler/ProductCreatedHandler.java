package com.rajasekhar.kafka.consumer.handler;

import com.rajasekhar.common.event.ProductCreatedEvent;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "product-created-events-topic")
public class ProductCreatedHandler {

    @KafkaHandler
    public void handleMessages(ProductCreatedEvent productCreatedEvent){
        System.out.println("Received an event *****"+productCreatedEvent.getName());
    }
}
