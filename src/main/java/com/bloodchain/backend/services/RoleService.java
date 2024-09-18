package com.bloodchain.backend.services;


import com.bloodchain.backend.models.Roles;

// import org.springframework.stereotype.Service;

// import com.bloodchain.backend.models.ERole;


public interface RoleService {
	
	public boolean existsByName(String name);
	public Roles addRoles(Roles roles);
}
