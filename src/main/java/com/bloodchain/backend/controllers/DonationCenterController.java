package com.bloodchain.backend.controllers;

import java.util.List;

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

import com.bloodchain.backend.dtos.DonationCenterDTO;
import com.bloodchain.backend.requests.DonationCenterAddRequest;
import com.bloodchain.backend.requests.DonationCenterEditRequest;
import com.bloodchain.backend.responses.DonationCenterAddResponse;
import com.bloodchain.backend.responses.DonationCenterEditResponse;
import com.bloodchain.backend.responses.DonationCenterDeleteResponse;
import com.bloodchain.backend.services.DonationCenterService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/donationCenter")
public class DonationCenterController {

    private final DonationCenterService donationCenterService;

    public DonationCenterController(DonationCenterService donationCenterService) {
        this.donationCenterService = donationCenterService;
    }

    @PostMapping("/add")
    public ResponseEntity<DonationCenterAddResponse> addDonationCenter(
            @RequestBody DonationCenterAddRequest donationAddRequest) {
        return ResponseEntity.ok(donationCenterService.addDonationCenter(donationAddRequest));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<DonationCenterDTO>> findAll() {
        return ResponseEntity.ok(donationCenterService.findAll());
    }

    @PutMapping("/edit")
    public ResponseEntity<DonationCenterEditResponse> editDonationCenter(
            @RequestBody DonationCenterEditRequest donationCenterEditRequest) {
        return ResponseEntity.ok(donationCenterService.editDonationCenter(donationCenterEditRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DonationCenterDeleteResponse> deleteDonationCenter(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(donationCenterService.deleteDonationCenter(id));
    }
}