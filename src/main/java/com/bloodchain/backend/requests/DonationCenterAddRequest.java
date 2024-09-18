package com.bloodchain.backend.requests;

public class DonationCenterAddRequest {
    private String name;
    private String location;
    private String adminCin;

    public DonationCenterAddRequest() {

    }

    public DonationCenterAddRequest(String name, String location, String adminCin) {
        this.name = name;
        this.location = location;
        this.adminCin = adminCin;
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

    public String getAdminCin() {
        return adminCin;
    }

    public void setAdminCin(String adminCin) {
        this.adminCin = adminCin;
    }

}
