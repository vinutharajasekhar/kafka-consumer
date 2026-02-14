package com.rajasekhar.kafka.consumer.handler;

import com.rajasekhar.common.event.ProductCreatedEvent;
import com.rajasekhar.kafka.consumer.error.NonRetryableException;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "product-created-events-topic")
public class ProductCreatedHandler {

    @KafkaHandler
    public void handleMessages(ProductCreatedEvent productCreatedEvent){
        if(true) {
            throw new NonRetryableException("Error took place which need not be Retried");
        }
        System.out.println("Received an event *****"+productCreatedEvent.getName());
    }
}
