package com.example.usermgmntservice.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendStudentEvent(String message) {
        kafkaTemplate.send("student-events", message);
    }

    public void sendTeacherEvent(String message) {
        kafkaTemplate.send("teacher-events", message);
    }
}
