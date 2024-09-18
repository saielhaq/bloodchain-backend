package com.bloodchain.backend.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bloodchain.backend.dtos.DonationCenterDTO;
import com.bloodchain.backend.models.DonationCenter;
import com.bloodchain.backend.models.ERole;
import com.bloodchain.backend.repository.DonationCenterRepository;
import com.bloodchain.backend.repository.UserRepository;
import com.bloodchain.backend.requests.DonationCenterAddRequest;
import com.bloodchain.backend.requests.DonationCenterEditRequest;
import com.bloodchain.backend.responses.DonationCenterAddResponse;
import com.bloodchain.backend.responses.DonationCenterDeleteResponse;
import com.bloodchain.backend.responses.DonationCenterEditResponse;
import com.bloodchain.backend.services.DonationCenterService;

@Service
public class DonationCenterServiceImpl implements DonationCenterService {

    private final UserRepository userRepository;
    private final DonationCenterRepository donationCenterRepository;

    public DonationCenterServiceImpl(UserRepository userRepository, DonationCenterRepository donationCenterRepository) {
        this.userRepository = userRepository;
        this.donationCenterRepository = donationCenterRepository;
    }

    @Override
    public DonationCenterAddResponse addDonationCenter(DonationCenterAddRequest donationCenterAddRequest) {
        var admin = userRepository.findByCin(donationCenterAddRequest.getAdminCin());

        if (!admin.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals(ERole.ADMIN.name()))) {
            return new DonationCenterAddResponse("User is not an administrator");
        }

        var donationCenter = new DonationCenter();
        donationCenter.setName(donationCenterAddRequest.getName());
        donationCenter.setLocation(donationCenterAddRequest.getLocation());
        donationCenter.setAdmin(admin);
        try {
            donationCenterRepository.save(donationCenter);
        } catch (Exception e) {
            return new DonationCenterAddResponse(e.getMessage());
        }
        return new DonationCenterAddResponse("Donation center added successfully");
    }

    @Override
    public List<DonationCenterDTO> findAll() {
        List<DonationCenter> donationCenters = donationCenterRepository.findAll();
        return donationCenters.stream().map(donationCenter -> {
            return new DonationCenterDTO(donationCenter.getDonationCenterId(), donationCenter.getName(),
                    donationCenter.getLocation(), donationCenter.getAdmin().getCin());
        }).collect(Collectors.toList());
    }

    @Override
    public DonationCenterEditResponse editDonationCenter(DonationCenterEditRequest donationCenterEditRequest) {
        var admin = userRepository.findByCin(donationCenterEditRequest.getAdminCin());
        var donationCenter = donationCenterRepository.findById(donationCenterEditRequest.getId());
        donationCenter.get().setDonationCenterId(donationCenterEditRequest.getId());
        donationCenter.get().setName(donationCenterEditRequest.getName());
        donationCenter.get().setLocation(donationCenterEditRequest.getLocation());
        donationCenter.get().setAdmin(admin);
        try {
            donationCenterRepository.save(donationCenter.get());
        } catch (Exception e) {
            return new DonationCenterEditResponse(e.getMessage());
        }
        return new DonationCenterEditResponse("Donation Center edited successfuly");
    }

    @Override
    public DonationCenterDeleteResponse deleteDonationCenter(Integer donationCenterId) {
        if (!donationCenterRepository.existsById(donationCenterId)) {
            return new DonationCenterDeleteResponse("Donation Center ID does not exist");
        }
        donationCenterRepository.deleteById(donationCenterId);
        return new DonationCenterDeleteResponse("Donation Center deleted successfully");
    }

}
