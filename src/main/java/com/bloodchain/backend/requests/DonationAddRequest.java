package com.bloodchain.backend.requests;

import java.util.Date;

import com.bloodchain.backend.models.EDonationStatus;
import com.bloodchain.backend.models.EDonationTypes;

public class DonationAddRequest {

    private EDonationTypes type;
    private Integer quantity;
    private Date donationDate;
    private EDonationStatus donationStatus;
    private String userCin;

    public DonationAddRequest() {
    }

    public DonationAddRequest(EDonationTypes type, Integer quantity, Date donationDate, EDonationStatus donationStatus,
            String userCin) {
        this.type = type;
        this.quantity = quantity;
        this.donationDate = new Date();
        this.donationStatus = donationStatus;
        this.userCin = userCin;
    }

    public EDonationTypes getType() {
        return type;
    }

    public void setType(EDonationTypes type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public EDonationStatus getDonationStatus() {
        return donationStatus;
    }

    public void setDonationStatus(EDonationStatus donationStatus) {
        this.donationStatus = donationStatus;
    }

    public String getUserCin() {
        return userCin;
    }

    public void setUserCin(String userCin) {
        this.userCin = userCin;
    }

}
