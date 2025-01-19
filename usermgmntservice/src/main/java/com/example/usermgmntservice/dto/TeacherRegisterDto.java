package com.example.usermgmntservice.dto;

import lombok.Data;

/**
 * @author Bibash Bogati
 * @created 2025-01-19
 */
@Data
public class TeacherRegisterDto extends UserRegisterRequestDto{

    private String name;

    private String email;

    private String subject;
}
