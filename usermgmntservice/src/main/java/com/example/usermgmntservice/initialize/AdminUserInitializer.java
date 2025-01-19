package com.example.usermgmntservice.initialize;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.example.usermanagementservice.dao.UserRepository;
import org.example.usermanagementservice.entity.Role;
import org.example.usermanagementservice.entity.User;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;

/**
 * @author Bibash Bogati
 * @created 2024-12-12
 */

@Slf4j
@Component
public class AdminUserInitializer {


    private final UserRepository userRepository;

    public AdminUserInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    void createPostUser() {
        User adminUser = userRepository.findByUsername("admin");
        if(adminUser == null) {
            User user = User.builder()
                    .role(Role.ADMIN)
                    .username("admin")
                    .password("admin")
                    .build();
            userRepository.save(user);
        } else {
            log.info("----- AdminUser already exists .. Skipping creation ----------");
        }
    }
}
