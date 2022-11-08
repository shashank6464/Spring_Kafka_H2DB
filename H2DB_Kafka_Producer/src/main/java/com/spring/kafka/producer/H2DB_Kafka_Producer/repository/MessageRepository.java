package com.spring.kafka.producer.H2DB_Kafka_Producer.repository;

import com.spring.kafka.producer.H2DB_Kafka_Producer.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

}