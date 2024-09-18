package com.bloodchain.backend.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "donation_center", uniqueConstraints = {
        @UniqueConstraint(columnNames = "donationCenterId")
})
public class DonationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donationCenterId;
    private String name;
    private String location;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "admin_id")
    private Users admin;

    public DonationCenter() {
    }

    public DonationCenter(String name, String location, Users admin) {
        this.name = name;
        this.location = location;
        this.admin = admin;
    }

    public Integer getDonationCenterId() {
        return donationCenterId;
    }

    public void setDonationCenterId(Integer donationCenterId) {
        this.donationCenterId = donationCenterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Users getAdmin() {
        return admin;
    }

    public void setAdmin(Users admin) {
        this.admin = admin;
    }

}
