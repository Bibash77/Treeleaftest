package org.example.controller;

import org.example.dto.GlobalAPIResponse;

/**
 * @author Bibash Bogati
 * @created 2024-12-12
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
