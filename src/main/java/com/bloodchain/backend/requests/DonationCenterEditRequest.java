package com.bloodchain.backend.requests;

public class DonationCenterEditRequest {
    private Integer id;
    private String name;
    private String location;
    private String adminCin;

    public DonationCenterEditRequest() {

    }

    public DonationCenterEditRequest(Integer id, String name, String location, String adminCin) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.adminCin = adminCin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
