package com.bloodchain.backend.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bloodchain.backend.models.ERole;
import com.bloodchain.backend.models.Roles;
import com.bloodchain.backend.services.RoleService;

@Configuration
public class DataRolesLoader {

	@Bean
	public ApplicationRunner loadRolesData(RoleService roleService) {
		return args -> {
			for (ERole eRole : ERole.values()) {
				if (!roleService.existsByName(eRole.name())) {
					Roles role = new Roles();
					role.setName(eRole.name());
					role.setERole(eRole);
					Roles newRole = roleService.addRoles(role);
					System.out.println("Initialization, added role: " + newRole.getName());
				}
			}
		};
	}
}
