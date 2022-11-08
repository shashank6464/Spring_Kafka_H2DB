package com.spring.kafka.consumer.H2DB_Kafka_Consumer.controller;

import com.spring.kafka.consumer.H2DB_Kafka_Consumer.consumer.TopicConsumer;
import com.spring.kafka.consumer.H2DB_Kafka_Consumer.model.Message;
import com.spring.kafka.consumer.H2DB_Kafka_Consumer.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka/consumer")
public class ConsumerController {

    private final TopicConsumer consumer;

    @Autowired
    private final MessageRepository repository;

    @GetMapping("/consume")
    public Message consume(){
        return consumer.getLoadedConsume();
    }

    @GetMapping("/getAllMessage")
    public List<Message> getAllMessage(){
        return repository.findAll();
    }

}
