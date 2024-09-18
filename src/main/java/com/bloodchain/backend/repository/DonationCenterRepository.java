package com.bloodchain.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodchain.backend.models.DonationCenter;

@Repository
public interface DonationCenterRepository extends JpaRepository<DonationCenter, Integer> {
}
