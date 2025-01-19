package com.example.usermgmntservice.controller;


import com.example.usermgmntservice.dto.GlobalAPIResponse;

/**
 * @author Bibash Bogati
 * @created 2024-12-18
 */
public class BaseController {

    protected GlobalAPIResponse successResponse(String message, Object data) {
        GlobalAPIResponse apiResponse = new GlobalAPIResponse();
        apiResponse.setMessage(message);
        apiResponse.setData(data);
        apiResponse.setStatus(true);
        return apiResponse;
    }
    protected GlobalAPIResponse failureResponse(String message, Object data) {
        GlobalAPIResponse apiResponse = new GlobalAPIResponse();
        apiResponse.setMessage(message);
        apiResponse.setData(data);
        apiResponse.setStatus(false);
        return apiResponse;
    }
}
