package com.bloodchain.backend.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Roles {
  @Id
  @GeneratedValue
  @Column(name = "role_id")
  private Integer roleId;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole eRole;
  
  private String name;
  
  public Roles() {
	  
  }
  public Roles(ERole eRole) {
	  this.eRole = eRole;
	  this.name=eRole.name();
  }

  /*public Roles(ERole eRole) {
    this.eRole = eRole;
  }*/
  
  @ManyToMany(mappedBy = "roles")
  private Set<Users> users;

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public ERole getERole() {
	  return this.eRole;
  }
  
  public void setERole(ERole eRole) {
	  this.eRole= eRole;
  }

}