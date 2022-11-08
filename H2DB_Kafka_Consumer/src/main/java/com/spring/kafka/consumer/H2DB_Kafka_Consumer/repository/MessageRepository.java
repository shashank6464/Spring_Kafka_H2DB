package com.spring.kafka.consumer.H2DB_Kafka_Consumer.repository;

import com.spring.kafka.consumer.H2DB_Kafka_Consumer.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {


}