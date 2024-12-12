package org.example.controller;


import org.example.config.JwtTokenUtil;
import org.example.dto.GlobalAPIResponse;
import org.example.dto.ResponseDTO;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<GlobalAPIResponse> register(@RequestParam String username, @RequestParam String password) {
        // Check if user already exists
        if (userService.findByUserName(username) != null) {
            return ResponseEntity.ok(failureResponse("User already exist", username));
        }

        // Save the user with password (you should hash the password before saving it)
        User user = new User();
        user.setUsername(username);
//      // Use a password encoder here for security  passwordEncoder.encode(password)
        user.setPassword(password);
        user.setRole(Role.USER);
        userService.save(user);

        return ResponseEntity.ok(successResponse("User registered", username));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all-users")
    public ResponseEntity<GlobalAPIResponse> getAllUsers() {
        return ResponseEntity.ok(successResponse("Users fetched succesfully", userService.getAllUsers()));
    }

    @PostMapping("/login")
    public ResponseEntity<GlobalAPIResponse> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.findByUserName(username);


        if (user != null && user.getPassword().equals(password)) {  // Simplified password check
            // Generate and return JWT token
            return ResponseEntity.ok(successResponse("Token Fetched Successfully", JwtTokenUtil.generateToken(username, List.of(user.getRole()))));

        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failureResponse("Invalid Username or password", username));
    }
}
