package com.example.usermgmntservice.dto;

import lombok.Data;

@Data
public class Notification {

    private String recipientName;
    private Long recipientId;
    private String message;


}
