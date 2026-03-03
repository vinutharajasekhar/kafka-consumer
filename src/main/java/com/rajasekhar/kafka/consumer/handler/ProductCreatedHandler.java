package com.rajasekhar.kafka.consumer.handler;

import com.rajasekhar.common.event.ProductCreatedEvent;
import com.rajasekhar.kafka.consumer.error.NonRetryableException;
import com.rajasekhar.kafka.consumer.error.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
@KafkaListener(topics = "product-created-events-topic")
public class ProductCreatedHandler {

    @Autowired
    RestTemplate restTemplate;
    @KafkaHandler
    public void handleMessages(ProductCreatedEvent productCreatedEvent){

        System.out.println("Received an event *****"+productCreatedEvent.getName());
        String url="http://localhost:8082/response/200";
        ResponseEntity<String> responseEntity;
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
            if(responseEntity.getStatusCode().value() == HttpStatus.OK.value()){
                System.out.println("Received response from a remote service "+responseEntity.getBody());
            }
        }catch (ResourceAccessException exc){
            throw  new RetryableException(exc);
        }catch (HttpServerErrorException exc){
            throw new NonRetryableException(exc);
        }catch (Exception exc){
            throw new NonRetryableException(exc);
        }

    }
}
