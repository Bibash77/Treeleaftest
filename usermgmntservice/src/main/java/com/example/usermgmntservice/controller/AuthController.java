package com.example.usermgmntservice.controller;



import com.example.usermgmntservice.config.JwtTokenUtilTest;
import com.example.usermgmntservice.config.security.v2.JwtTokenUtil;
import com.example.usermgmntservice.dto.GlobalAPIResponse;
import com.example.usermgmntservice.dto.StudentRegisterDto;
import com.example.usermgmntservice.dto.TeacherRegisterDto;
import com.example.usermgmntservice.entity.User;
import com.example.usermgmntservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController extends BaseController {

    @Autowired
    private UserService userService;



    // open api
    @PostMapping("/register-student")
    public ResponseEntity<GlobalAPIResponse> registerStudent(@RequestBody StudentRegisterDto studentRegisterDto) {
        User user = userService.registerStudent(studentRegisterDto);
        return ResponseEntity.ok(successResponse("User registered", user.getUsername()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-teacher")
    public ResponseEntity<GlobalAPIResponse> createTeacher(@RequestBody TeacherRegisterDto teacherRegisterDto) {
        User user = userService.createTeacher(teacherRegisterDto);
        return ResponseEntity.ok(successResponse("Teacher created", user.getUsername()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all-users")
    public ResponseEntity<GlobalAPIResponse> getAllUsers() {
        return ResponseEntity.ok(successResponse("Users fetched successfully", userService.getAllUsers()));
    }

    @GetMapping("/login")
    public ResponseEntity<GlobalAPIResponse> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.findByUserName(username);
        // use password encoder later
        if (user != null && user.getPassword().equals(password)) {  // Simplified password check
            // Generate and return JWT token
            return ResponseEntity.ok(successResponse("User Logged In Successfully", JwtTokenUtil.generateToken(username, List.of(user.getRole()))));

        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failureResponse("Invalid Username or password", username));
    }
}
