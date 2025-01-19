package com.example.usermgmntservice.service;


import com.example.usermgmntservice.dao.UserRepository;
import com.example.usermgmntservice.dto.StudentRegisterDto;
import com.example.usermgmntservice.dto.TeacherRegisterDto;
import com.example.usermgmntservice.entity.Role;
import com.example.usermgmntservice.entity.Student;
import com.example.usermgmntservice.entity.Teacher;
import com.example.usermgmntservice.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bibash Bogati
 * @created 2024-12-18
 */

// No need of interface for now
@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final StudentService studentService;
    private final TeacherService teacherService;


    public User findByUserName(String author) {
        return userRepository.findByUsername(author);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    // change to dto later
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User registerStudent(StudentRegisterDto studentRegisterDto) {

        if (findByUserName(studentRegisterDto.getUsername()) != null) {
            throw new RuntimeException("Username is already in use");
        }
        // Save the user with password ( hash the password before saving it)
        User user = User.builder()
                .username(studentRegisterDto.getUsername())
                .password(studentRegisterDto.getPassword())
                .role(Role.STUDENT)
                .build();

        Student student = Student.builder()
                .email(studentRegisterDto.getEmail())
                .name(studentRegisterDto.getName())
                .user(user).build();
        studentService.createStudent(student);
        return user;
    }

    public User createTeacher(TeacherRegisterDto teacherRegisterDto) {


        if (findByUserName(teacherRegisterDto.getUsername()) != null) {
            throw new RuntimeException("Username is already in use");
        }
        // Save the user with password ( hash the password before saving it)
        User user = User.builder()
                .username(teacherRegisterDto.getUsername())
                .password(teacherRegisterDto.getPassword())
                .role(Role.TEACHER).build();

        Teacher teacher = Teacher.builder()
                .email(teacherRegisterDto.getEmail())
                .name(teacherRegisterDto.getName())
                .user(user)
                .build();
        teacherService.createTeacher(teacher);
        return user;
    }
}
