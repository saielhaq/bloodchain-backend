package com.bloodchain.backend.responses;

public class UserEditResponse {
    private String message;

    public UserEditResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
