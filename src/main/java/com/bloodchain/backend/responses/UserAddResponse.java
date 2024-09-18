package com.bloodchain.backend.responses;

import java.util.Set;

import com.bloodchain.backend.models.Roles;

public class UserAddResponse {
    private Integer id;
    private String cin;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Set<Roles> roles;

    public UserAddResponse() {
    }

    public UserAddResponse(Integer id, String cin, String firstname, String lastname, String email, String password,
            Set<Roles> roles) {
        this.id = id;
        this.cin = cin;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

}
