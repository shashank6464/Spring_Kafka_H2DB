package com.spring.kafka.producer.H2DB_Kafka_Producer.model;

public class User {
    private String name;
    private String location;
    private int number;

    public User() {
    }

    public User(String name, String location, int number) {
        this.name = name;
        this.location = location;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", number=" + number +
                '}';
    }
}
