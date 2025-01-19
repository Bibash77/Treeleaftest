package com.example.usermgmntservice.dto;

import jakarta.persistence.Column;
import lombok.Data;

/**
 * @author Bibash Bogati
 * @created 2025-01-19
 */

@Data
public class StudentRegisterDto {

    private String username;
    private String password;
    private String name;
    private String email;
}
