package com.bloodchain.backend.services.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.bloodchain.backend.models.ERole;
import com.bloodchain.backend.models.Roles;
import com.bloodchain.backend.repository.RolesRepository;
import com.bloodchain.backend.services.RoleService;

@Service
public class RoleServiceImp implements RoleService {
	
	private RolesRepository rolesRepository;
	
	@Autowired
	public RoleServiceImp(RolesRepository rolesRepository) {
		this.rolesRepository = rolesRepository;
	}
	
	
	@Override
	public boolean existsByName(String roleName) {
		
		//Roles role = new Roles(erole);
		//role.setName(erole.name());
		
		return rolesRepository.existsByName(roleName);
	};
	
	@Override
	public Roles addRoles(Roles roles) {
		return rolesRepository.save(roles);
	}
	
}
