package com.hong.kafka.configuration;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
@Configuration
public class KafkaTopicConfiguration {
// 카프카 정보 가져오기


//    KafkaAdmin 내부에 context가 초기화될 때 initialize()메소드가 실행됨
// 이미 있는 토픽은 파티션만 바꿀 수 있음
    @Bean
    public KafkaAdmin.NewTopics nodamTopic() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("testhong").build(),
                TopicBuilder.name("byte-test").build(),
                TopicBuilder.name("request-topic").build(),
                TopicBuilder.name("replies-topic").build()
        );
    }
}
