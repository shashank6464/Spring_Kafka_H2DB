package com.spring.kafka.producer.H2DB_Kafka_Producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data // it will take care all CURD
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue
    private int id;

    private String fromUser;

    private String toUser;

    private String message;

    private String h2Database="Producer";

    public Message( String fromUser, String toUser, String message) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", fromUser='" + fromUser + '\'' +
                ", toUser='" + toUser + '\'' +
                ", message='" + message + '\'' +
                ", h2Database='" + h2Database + '\'' +
                '}';
    }

    public static Message extractFromString(String messageString){
        messageString=messageString.substring(1,messageString.length()-1);
        String[] data = messageString.split(", ");
        List<String> data_ = Arrays.stream(data).collect(Collectors.toList());
        Message message = new Message();
        for (String keyValue:
                data_) {
            List<String> key_value = Arrays.stream(keyValue.split("=")).collect(Collectors.toList());
            if(key_value.get(0).equals("fromUser"))     message.setFromUser(key_value.get(1).substring(1,key_value.get(1).length()-1));
            if(key_value.get(0).equals("toUser"))     message.setToUser(key_value.get(1).substring(1,key_value.get(1).length()-1));
            if(key_value.get(0).equals("message"))     message.setMessage(key_value.get(1).substring(1,key_value.get(1).length()-1));
        }
        return message;
    }
}