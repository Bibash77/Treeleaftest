package com.example.usermgmntservice.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic studentTopic() {
        return TopicBuilder.name("student-events").build();
    }

    @Bean
    public NewTopic teacherTopic() {
        return TopicBuilder.name("teacher-events").build();
    }
}
