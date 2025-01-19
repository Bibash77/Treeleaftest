package com.example.usermgmntservice.initialize;

import com.example.usermgmntservice.dao.UserRepository;
import com.example.usermgmntservice.entity.Role;
import com.example.usermgmntservice.entity.User;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Bibash Bogati
 * @created 2024-12-18
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
        if (adminUser == null) {
            User user = User.builder().role(Role.ADMIN).username("admin").password("admin").build();
            userRepository.save(user);
        } else {
            log.info("----- AdminUser already exists .. Skipping creation ----------");
        }
    }
}
