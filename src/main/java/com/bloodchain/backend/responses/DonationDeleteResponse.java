package com.bloodchain.backend.responses;

public class DonationDeleteResponse {
    private String message;

    public DonationDeleteResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
