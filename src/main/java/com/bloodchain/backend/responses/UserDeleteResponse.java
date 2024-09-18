package com.bloodchain.backend.responses;

public class UserDeleteResponse {
    private String message;

    public UserDeleteResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
