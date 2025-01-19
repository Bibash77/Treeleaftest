package com.example.usermgmntservice.dao;

import org.example.usermanagementservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bibash Bogati
 * @created 2024-12-11
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
