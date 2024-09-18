package com.bloodchain.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bloodchain.backend.dtos.DonationDTO;
import com.bloodchain.backend.requests.DonationAddRequest;
import com.bloodchain.backend.requests.DonationEditRequest;
import com.bloodchain.backend.responses.DonationAddResponse;
import com.bloodchain.backend.responses.DonationDeleteResponse;
import com.bloodchain.backend.responses.DonationEditResponse;

@Service
public interface DonationService {
    DonationAddResponse addDonation(DonationAddRequest donationAddRequest);

    List<DonationDTO> getDonationsHistory();

    List<DonationDTO> getDonorHistory(Integer userId);

    DonationDTO getDonationById(Integer donationId);

    DonationDeleteResponse deleteDonation(Integer donationId);

    DonationEditResponse editDonation(DonationEditRequest donationEditRequest);
}
