package com.example.usermgmntservice.service;



import com.example.usermgmntservice.dao.StudentRepository;
import com.example.usermgmntservice.entity.Student;
import com.example.usermgmntservice.producer.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final KafkaProducerService kafkaProducerService;

    @Cacheable("students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // redis templates can be used for complex situation
    // for now implemented simple cacheable with eviction
    @Cacheable(value = "students", key = "#id")
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        kafkaProducerService.sendStudentEvent("New Student Created: " + savedStudent.getName());
        return savedStudent;
    }

    @CacheEvict(value = "students", key = "#id")
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}