package com.bloodchain.backend.requests;

import java.util.Set;
import java.util.Date;

import com.bloodchain.backend.models.ERole;

public class UserAddRequest {

    private String cin;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Set<ERole> roles;

    public UserAddRequest(String cin, String firstname, String lastname, String email, String password,
            Set<ERole> roles) {
        this.cin = cin;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ERole> getRoles() {
        return roles;
    }

    public void setRoles(Set<ERole> roles) {
        this.roles = roles;
    }

}
