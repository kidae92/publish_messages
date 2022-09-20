package com.hong.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


public class Consumer {

    @KafkaListener(id = "nodam-project", topics = "testhong")
    public void listen(String message){
        System.out.println("=======");
        System.out.println(message);
        System.out.println("=======");
    }
}
