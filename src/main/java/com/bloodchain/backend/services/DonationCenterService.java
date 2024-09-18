package com.bloodchain.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bloodchain.backend.dtos.DonationCenterDTO;
import com.bloodchain.backend.requests.DonationCenterAddRequest;
import com.bloodchain.backend.requests.DonationCenterEditRequest;
import com.bloodchain.backend.responses.DonationCenterAddResponse;
import com.bloodchain.backend.responses.DonationCenterDeleteResponse;
import com.bloodchain.backend.responses.DonationCenterEditResponse;

@Service
public interface DonationCenterService {
    DonationCenterAddResponse addDonationCenter(DonationCenterAddRequest donationAddRequest);
    List<DonationCenterDTO> findAll();
    DonationCenterEditResponse editDonationCenter(DonationCenterEditRequest donationCenterEditRequest);
    DonationCenterDeleteResponse deleteDonationCenter(Integer donationCenterId);
}
