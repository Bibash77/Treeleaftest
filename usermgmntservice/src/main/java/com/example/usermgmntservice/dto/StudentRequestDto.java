package com.example.usermgmntservice.dto;

import lombok.Data;

/**
 * @author Bibash Bogati
 * @created 2025-01-18
 */
@Data
public class StudentRequestDto extends UserRegisterRequestDto{

    private String name;

    private String email;

    private Integer classNo;


}
