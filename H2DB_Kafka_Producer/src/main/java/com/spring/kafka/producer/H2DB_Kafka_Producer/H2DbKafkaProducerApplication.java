package com.spring.kafka.producer.H2DB_Kafka_Producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class H2DbKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2DbKafkaProducerApplication.class, args);
	}

}
