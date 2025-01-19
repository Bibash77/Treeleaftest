package com.example.usermgmntservice.controller;


import com.example.usermgmntservice.dto.GlobalAPIResponse;
import com.example.usermgmntservice.entity.Teacher;
import com.example.usermgmntservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController extends BaseController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<GlobalAPIResponse> getAllTeachers() {
        return ResponseEntity.ok(successResponse("Fetched Teacher List !!", teacherService.getAllTeachers()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalAPIResponse> getTeacherById(@PathVariable Long id) {
        return ResponseEntity.ok(successResponse("Fetched teacher !!", teacherService.getTeacherById(id)));

    }

    @PostMapping
    public ResponseEntity<GlobalAPIResponse> createTeacher(@RequestBody Teacher teacher) {
        return ResponseEntity.ok(successResponse("Created teacher !!", teacherService.createTeacher(teacher)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalAPIResponse> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok(successResponse("Deleted teacher !!", id));

    }
}