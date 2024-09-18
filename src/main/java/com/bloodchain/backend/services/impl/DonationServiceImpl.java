package com.bloodchain.backend.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bloodchain.backend.dtos.DonationDTO;
import com.bloodchain.backend.models.Donation;
import com.bloodchain.backend.models.EDonationStatus;
import com.bloodchain.backend.models.Users;
import com.bloodchain.backend.repository.DonationRepository;
import com.bloodchain.backend.repository.UserRepository;
import com.bloodchain.backend.requests.DonationAddRequest;
import com.bloodchain.backend.requests.DonationEditRequest;
import com.bloodchain.backend.responses.DonationAddResponse;
import com.bloodchain.backend.responses.DonationDeleteResponse;
import com.bloodchain.backend.responses.DonationEditResponse;
import com.bloodchain.backend.services.DonationService;

@Service
public class DonationServiceImpl implements DonationService {

    private final UserRepository userRepository;
    private final DonationRepository donationRepository;

    public DonationServiceImpl(UserRepository userRepository, DonationRepository donationRepository) {
        this.userRepository = userRepository;
        this.donationRepository = donationRepository;
    }

    @Override
    public DonationAddResponse addDonation(DonationAddRequest donationAddRequest) {
        var user = userRepository.findByCin(donationAddRequest.getUserCin());
        var donation = new Donation();
        DonationAddResponse newDonation;
        donation.setType(donationAddRequest.getType());
        donation.setQuantity(donationAddRequest.getQuantity());
        donation.setDonationDate(new Date());
        donation.setStatus(EDonationStatus.PENDING);
        donation.setUser(user);
        try {
            newDonation = convertToResponse(donationRepository.save(donation));

        } catch (Exception e) {
            return null;
        }
        return newDonation;
    }

    @Override
    public List<DonationDTO> getDonationsHistory() {
        List<Donation> response = donationRepository.findAll();
        return response.stream().map(donation -> {
            return new DonationDTO(donation.getDonationId(), donation.getType(), donation.getQuantity(),
                    donation.getDonationDate(), donation.getStatus(), donation.getUser().getCin());
        }).collect(Collectors.toList());
    }


    @Override
    public DonationDTO getDonationById(Integer donationId) {
        Optional<Donation> donation = donationRepository.findById(donationId);
        
        if (donation.isPresent()) {
            DonationDTO donationDTO = new DonationDTO(
                donation.get().getDonationId(),
                donation.get().getType(),
                donation.get().getQuantity(),
                donation.get().getDonationDate(),
                donation.get().getStatus(),
                donation.get().getUser().getCin()
            );
            return donationDTO;
        } else {
            return null;
        }
    }
    

    @Override
    public List<DonationDTO> getDonorHistory(Integer userId) {
        Optional<Users> user = userRepository.findById(userId);
        List<Donation> response = donationRepository.findAllByUser(user);
        return response.stream().map(donation -> {
            return new DonationDTO(donation.getDonationId(), donation.getType(), donation.getQuantity(),
                    donation.getDonationDate(), donation.getStatus(), user.get().getCin());
        }).collect(Collectors.toList());
    }

    @Override
    public DonationDeleteResponse deleteDonation(Integer donationId) {
        if (!donationRepository.existsById(donationId)) {
            return new DonationDeleteResponse("Donation ID donation exist");
        }
        donationRepository.deleteById(donationId);
        return new DonationDeleteResponse("Donation deleted successfuly");
    }

    @Override
    public DonationEditResponse editDonation(DonationEditRequest donationEditRequest) {
        var user = userRepository.findByCin(donationEditRequest.getUserCin());
        var donation = donationRepository.findById(donationEditRequest.getId()).get();
        DonationEditResponse editedDonation;
        donation.setDonationId(donationEditRequest.getId());
        donation.setType(donationEditRequest.getdonationType());
        donation.setQuantity(donationEditRequest.getQuantity());
        donation.setDonationDate(donationEditRequest.getDonationDate());
        donation.setStatus(donationEditRequest.getDonationStatus());
        donation.setUser(user);
        try {
            editedDonation = convertEditResponse(donationRepository.save(donation));
        } catch (Exception e) {
            return null;
        }
        return editedDonation;
    }

    private DonationAddResponse convertToResponse(Donation donation){
        return new DonationAddResponse(donation.getDonationId(), donation.getType(), donation.getQuantity(), donation.getDonationDate(), donation.getStatus(), donation.getUser().getCin());
    }

    private DonationEditResponse convertEditResponse(Donation donation){
        return new DonationEditResponse(donation.getDonationId(), donation.getType(), donation.getQuantity(), donation.getDonationDate(), donation.getStatus(), donation.getUser().getCin());
    }

}
