package com.example.usermgmntservice.controller;


import com.example.usermgmntservice.dto.GlobalAPIResponse;
import com.example.usermgmntservice.entity.Student;
import com.example.usermgmntservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController extends BaseController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<GlobalAPIResponse> getAllStudents() {
        return ResponseEntity.ok(successResponse("Fetched Student List !!", studentService.getAllStudents()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalAPIResponse> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(successResponse("Fetched student !!", studentService.getStudentById(id)));

    }

    @PostMapping
    public ResponseEntity<GlobalAPIResponse> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(successResponse("Created student !!", studentService.createStudent(student)));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalAPIResponse> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);

        return ResponseEntity.ok(successResponse("Student Deleted !! ", id));
    }
}
