package com.rajasekhar.kafka.consumer.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "processed_message")
public class ProcessedMessage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "message_id", unique = true, nullable = false)
    private String messageId;
    @Column(name = "product_id", nullable = false)
    private String productId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ProcessedMessage() {
    }

    public ProcessedMessage(String messageId, String productId) {
        this.messageId = messageId;
        this.productId = productId;
    }
}
