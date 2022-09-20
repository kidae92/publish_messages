package com.hong.kafka.producer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.KafkaTemplate;

public class producer {
    public ApplicationRunner runner(KafkaTemplate<String, String> kafkaTemplate){
        return args -> {
            kafkaTemplate.send("testhong", "hello-world");
        };
    }
}
