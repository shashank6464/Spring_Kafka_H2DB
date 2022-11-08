package com.spring.kafka.producer.H2DB_Kafka_Producer.controller;

import com.spring.kafka.producer.H2DB_Kafka_Producer.model.Message;
import com.spring.kafka.producer.H2DB_Kafka_Producer.model.User;
import com.spring.kafka.producer.H2DB_Kafka_Producer.producer.TopicProducer;
import com.spring.kafka.producer.H2DB_Kafka_Producer.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka/producer")
public class ProducerController {
    private final TopicProducer topicProducer;

    @Autowired
    private MessageRepository repository;

    @GetMapping("/send/{name}")
    public void send(@PathVariable("name") String name){
        topicProducer.send("Hello! "+name+".");
    }

    @PostMapping("/send")
    public Message send(@RequestBody Message message){
        return topicProducer.send(message.toString());

    }

    @GetMapping("/getAllMessage")
    public List<Message> getAllMessage(){
        return repository.findAll();
    }

}
