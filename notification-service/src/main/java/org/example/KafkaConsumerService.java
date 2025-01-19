package org.example;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "student-events", groupId = "student-group")
    public void consumeStudentEvent(String message) {
        System.out.println("Consumed Student Event: " + message);
    }

    @KafkaListener(topics = "teacher-events", groupId = "teacher-group")
    public void consumeTeacherEvent(String message) {
        System.out.println("Consumed Teacher Event: " + message);
    }
}
