package com.example.usermgmntservice.dao;

import com.example.usermgmntservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bibash Bogati
 * @created 2024-12-18
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
