package com.hong.kafka;

import com.hong.kafka.producer.ClipProducer;
import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.admin.TopicListing;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@SpringBootApplication
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
    @Bean
    public ApplicationRunner runner(ClipProducer clipProducer){
        return args -> {
            clipProducer.async("testhong", "hello-async");
            clipProducer.sync("testhong", "hello-sync");
            clipProducer.routingSend("testhong", "rout rout");
            clipProducer.routingSendBytes("byte-test", "byte-test".getBytes(StandardCharsets.UTF_8));
            clipProducer.replyingSend("request-topic", "Ping request");
            Thread.sleep(1000L);
        };
    }


}



