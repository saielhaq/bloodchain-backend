package com.bloodchain.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodchain.backend.requests.DonationAddRequest;
import com.bloodchain.backend.requests.DonationEditRequest;
import com.bloodchain.backend.dtos.DonationDTO;
import com.bloodchain.backend.models.Donation;
import com.bloodchain.backend.repository.DonationRepository;
import com.bloodchain.backend.responses.DonationAddResponse;
import com.bloodchain.backend.responses.DonationDeleteResponse;
import com.bloodchain.backend.responses.DonationEditResponse;
import com.bloodchain.backend.services.DonationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/donation")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping("/add")
    public ResponseEntity<DonationAddResponse> addDonation(@RequestBody DonationAddRequest donationAddRequest) {
        return ResponseEntity.ok(donationService.addDonation(donationAddRequest));
    }

    @GetMapping("/getHistory")
    public ResponseEntity<List<DonationDTO>> getDonationsHistory() {
        return ResponseEntity.ok(donationService.getDonationsHistory());
    }

    @GetMapping("/getDonorHistory/{id}")
    public ResponseEntity<List<DonationDTO>> getDonorHistory(@PathVariable("id") Integer userId) {
        return ResponseEntity.ok(donationService.getDonorHistory(userId));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DonationDTO> getDonationById(@PathVariable("id") Integer donationId){
        return ResponseEntity.ok(donationService.getDonationById(donationId));
    }

    @PutMapping("/edit")
    public ResponseEntity<DonationEditResponse> editDonation(@RequestBody DonationEditRequest donationEditRequest) {
        return ResponseEntity.ok(donationService.editDonation(donationEditRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DonationDeleteResponse> deleteDonation(@PathVariable("id") Integer donationId) {
        return ResponseEntity.ok(donationService.deleteDonation(donationId));
    }

} 
