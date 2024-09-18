package com.bloodchain.backend;

import java.util.Date;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bloodchain.backend.models.Donation;
import com.bloodchain.backend.models.DonationCenter;
import com.bloodchain.backend.models.EDonationStatus;
import com.bloodchain.backend.models.ERole;
import com.bloodchain.backend.models.EDonationTypes;
import com.bloodchain.backend.models.Roles;
import com.bloodchain.backend.models.Users;
import com.bloodchain.backend.repository.DonationCenterRepository;
import com.bloodchain.backend.repository.DonationRepository;
import com.bloodchain.backend.repository.RolesRepository;
import com.bloodchain.backend.repository.UserRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final RolesRepository rolesRepository;
	private final DonationRepository donationRepository;
	private DonationCenterRepository donationCenterRepository;

	public BackendApplication(UserRepository userRepository, RolesRepository rolesRepository,
			DonationRepository donationRepository, DonationCenterRepository donationCenterRepository) {
		this.userRepository = userRepository;
		this.rolesRepository = rolesRepository;
		this.donationRepository = donationRepository;
		this.donationCenterRepository = donationCenterRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// rolesRepository.save(new Roles(ERole.SUPERADMIN));
		// rolesRepository.save(new Roles(ERole.ADMIN));
		// rolesRepository.save(new Roles(ERole.RESPONSIBLE));
		// rolesRepository.save(new Roles(ERole.DOCTOR));
		// rolesRepository.save(new Roles(ERole.ANALYST));
		// rolesRepository.save(new Roles(ERole.DONOR));
// userRepository.save(new Users("BE938769", "Saad", "Sai El Haq",
		// "saad@mail.test", "password", null, new Date(),
		// new Date(), Set.of(new Roles(ERole.ADMIN), new Roles(ERole.DONOR))));
		// donationCenterRepository.save(new DonationCenter("Centre ibn rochd",
		// "27 Bd Mohamed Zerktouni, Casablanca 20250, Maroc",
		// userRepository.findByCin("BE938769")));
		// donationRepository.save(new Donation(EDonationTypes.BLOOD, 1000, new Date(),
		// EDonationStatus.PENDING,
		// userRepository.findByCin("BE938769")));

		// rolesRepository.save(new Roles(ERole.SUPERADMIN));
		// rolesRepository.save(new Roles(ERole.ADMIN));
		// rolesRepository.save(new Roles(ERole.RESPONSIBLE));
		// rolesRepository.save(new Roles(ERole.DOCTOR));
		// rolesRepository.save(new Roles(ERole.ANALYST));
		// rolesRepository.save(new Roles(ERole.DONOR));
		// userRepository.save(new Users("BE938769", "Saad", "Sai El Haq", "saad@mail.test", "password", null, new Date(),
		// 		new Date(), Set.of(new Roles(ERole.ADMIN), new Roles(ERole.DONOR))));
		// donationCenterRepository.save(new DonationCenter("Centre ibn rochd",
		// 		"27 Bd Mohamed Zerktouni, Casablanca 20250, Maroc", userRepository.findByCin("BE938769")));
		// donationRepository.save(new Donation(EDonationTypes.BLOOD, 1000, new Date(), EDonationStatus.PENDING,
		// 		userRepository.findByCin("BE938769")));
	}

}
