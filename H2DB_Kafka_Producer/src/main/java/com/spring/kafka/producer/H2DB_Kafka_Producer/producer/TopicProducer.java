package com.spring.kafka.producer.H2DB_Kafka_Producer.producer;


import com.spring.kafka.producer.H2DB_Kafka_Producer.model.Message;
import com.spring.kafka.producer.H2DB_Kafka_Producer.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j // setter/getter/constructor/table
@RequiredArgsConstructor
@Service
public class TopicProducer {
    @Value("${topic.name.producer}")
    private String topicName;


    @Autowired
    private MessageRepository repository;

    private final KafkaTemplate<String,String> kafkaTemplate;

    public Message send(String message){

        kafkaTemplate.send(topicName,message);
        return repository.save(Message.extractFromString(message));

    }
}



