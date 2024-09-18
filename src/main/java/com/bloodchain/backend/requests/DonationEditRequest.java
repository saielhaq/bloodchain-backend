package com.bloodchain.backend.requests;

import java.util.Date;

import com.bloodchain.backend.models.EDonationStatus;
import com.bloodchain.backend.models.EDonationTypes;

public class DonationEditRequest {
    private Integer id;
    // private EDonationTypes type;
    private EDonationTypes donationType;
    private Integer quantity;
    private Date donationDate;
    private EDonationStatus donationStatus;
    private String userCin;

    public DonationEditRequest() {
    }

    public DonationEditRequest(Integer id, EDonationTypes donationType, Integer quantity, Date donationDate,
                               EDonationStatus donationStatus, String userCin) {
        this.id = id;
        this.donationType = donationType;
        this.quantity = quantity;
        this.donationDate = donationDate;
        this.donationStatus = donationStatus;
        this.userCin = userCin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EDonationTypes getdonationType() {
        return donationType;
    }

    public void setdonationType(EDonationTypes donationType) {
        this.donationType = donationType;
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
