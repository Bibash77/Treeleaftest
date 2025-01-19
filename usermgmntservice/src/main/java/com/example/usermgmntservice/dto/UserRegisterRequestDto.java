package com.example.usermgmntservice.dto;

import lombok.Data;

/**
 * @author Bibash Bogati
 * @created 2025-01-19
 */
@Data
public abstract class UserRegisterRequestDto {
    private String username;

    private String password;

}
