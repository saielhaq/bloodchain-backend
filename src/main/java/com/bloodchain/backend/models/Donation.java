package com.bloodchain.backend.models;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "donations", uniqueConstraints = {
        @UniqueConstraint(columnNames = "donation_id")
})
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donation_id", nullable = false)
    private Integer donationId;

    @Enumerated(EnumType.STRING)
    @Column
    private EDonationTypes donationType;

    private Integer quantity;
    private Date donationDate;

    @Enumerated(EnumType.STRING)
    @Column
    private EDonationStatus donationStatus;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public Donation() {

    }

    public Donation(EDonationTypes donationType, Integer quantity, Date donationDate, EDonationStatus donationStatus,
            Users user) {
        this.donationType = donationType;
        this.quantity = quantity;
        this.donationDate = donationDate;
        this.donationStatus = donationStatus;
        this.user = user;
    }

    public Integer getDonationId() {
        return donationId;
    }

    public void setDonationId(Integer donationId) {
        this.donationId = donationId;
    }

    public EDonationTypes getType() {
        return donationType;
    }

    public void setType(EDonationTypes type) {
        this.donationType = type;
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

    public EDonationStatus getStatus() {
        return donationStatus;
    }

    public void setStatus(EDonationStatus status) {
        this.donationStatus = status;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
