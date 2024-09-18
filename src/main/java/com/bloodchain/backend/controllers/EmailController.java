package com.bloodchain.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodchain.backend.services.EmailService;
import com.bloodchain.backend.requests.EmailRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @PostMapping("/sendAccountCreation")
    public ResponseEntity<String> sendAccountCreationEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendAccountCreationEmail(emailRequest);
        return ResponseEntity.ok("Email sent successfully");
    }

    @PostMapping("/sendDonationValidation")
    public ResponseEntity<String> sendDonationValidationEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest);
        return ResponseEntity.ok("Email sent successfully");
    }
}
