package com.bloodchain.backend.responses;

public class DonationCenterAddResponse {

    private String message;

    public DonationCenterAddResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
