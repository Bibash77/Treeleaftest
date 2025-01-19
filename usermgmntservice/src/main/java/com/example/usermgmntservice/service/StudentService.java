package com.example.usermgmntservice.service;


import org.example.usermanagementservice.dao.StudentRepository;
import org.example.usermanagementservice.entity.Student;
import org.example.usermanagementservice.producer.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Cacheable("students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Cacheable(value = "students", key = "#id")
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        kafkaProducerService.sendStudentEvent("New Student Created: " + savedStudent.getName());
        return savedStudent;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}