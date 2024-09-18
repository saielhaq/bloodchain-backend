package com.bloodchain.backend.dtos;

import java.util.Date;

import com.bloodchain.backend.models.EDonationStatus;
import com.bloodchain.backend.models.EDonationTypes;

public class DonationDTO {

    private Integer id;
    private EDonationTypes donationType;

    private Integer quantity;
    private Date donationDate;
    private EDonationStatus donationStatus;

    private String userCin;

    public DonationDTO() {

    }

    public DonationDTO(Integer id, EDonationTypes donationType, Integer quantity, Date donationDate,
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

    public EDonationTypes getDonationType() {
        return donationType;
    }

    public void setDonationType(EDonationTypes donationType) {
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
