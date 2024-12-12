package org.example.service;

import org.example.dao.UserRepository;
import org.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bibash Bogati
 * @created 2024-12-11
 */

// No need of interface for now
@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
}
