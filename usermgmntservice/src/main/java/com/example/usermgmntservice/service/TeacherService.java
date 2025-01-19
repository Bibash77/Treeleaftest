package com.example.usermgmntservice.service;


import org.example.usermanagementservice.dao.TeacherRepository;
import org.example.usermanagementservice.entity.Teacher;
import org.example.usermanagementservice.producer.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private KafkaProducerService kafkaProducerService;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public Teacher createTeacher(Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);
        kafkaProducerService.sendTeacherEvent("New Teacher Created: " + savedTeacher.getName());
        return savedTeacher;
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}