package com.bloodchain.backend.responses;

public class DonationCenterEditResponse {

    private String message;

    public DonationCenterEditResponse() {
    }

    public DonationCenterEditResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
