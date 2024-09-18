package com.bloodchain.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bloodchain.backend.models.ERole;
import com.bloodchain.backend.models.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer>{
    //Roles findByName(ERole role);
	Roles findByName(String roleName);
	//Roles findByERole(ERole eRole);
	boolean existsByName(String roleName);
}