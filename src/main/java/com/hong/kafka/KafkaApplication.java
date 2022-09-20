package com.hong.kafka;

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

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@SpringBootApplication
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
    @Bean
    public ApplicationRunner runner(AdminClient adminClient){
        return args -> {
            Map<String, TopicListing> topics = adminClient.listTopics().namesToListings().get();
            for (String topicName : topics.keySet()) {
                TopicListing topicListing = topics.get(topicName);
                System.out.println(topicListing);

                KafkaFuture<Map<String, TopicDescription>> description = adminClient.describeTopics(Collections.singleton(topicName)).all();
                System.out.println(description);

            }


        };
    }


}



