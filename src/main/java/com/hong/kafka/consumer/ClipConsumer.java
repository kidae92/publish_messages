package com.hong.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class ClipConsumer {

    @KafkaListener(id = "hong", topics = "testhong")
    public void listenClip(String message){
        System.out.println(message);
    }

    @KafkaListener(id = "hongbytes", topics = "byte-test")
    public void listenClipBytes(String message){
        System.out.println(message);
    }

    @KafkaListener(id = "hong-request", topics = "request-topic")
    @SendTo
    public String listenClipRequest(String message){
        System.out.println(message);
        return "Pong request";
    }
}
