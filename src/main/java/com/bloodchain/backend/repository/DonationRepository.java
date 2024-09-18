package com.bloodchain.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodchain.backend.models.Donation;
import com.bloodchain.backend.models.Users;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
    List<Donation> findAllByUser(Optional<Users> user);
}
