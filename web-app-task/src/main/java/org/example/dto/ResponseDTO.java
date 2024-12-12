package org.example.dto;

public class ResponseDTO {

    private String message;
    private Object data;

    // Constructor for successful responses
    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    // Constructor for error responses
    public ResponseDTO(String message) {
        this.message = message;
        this.data = null;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
