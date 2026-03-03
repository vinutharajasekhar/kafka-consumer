package com.rajasekhar.kafka.consumer.repository;

import com.rajasekhar.kafka.consumer.entity.ProcessedMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessedMessageRepository extends JpaRepository<ProcessedMessage, Long> {

    ProcessedMessage findByMessageId(String messageId);
}
