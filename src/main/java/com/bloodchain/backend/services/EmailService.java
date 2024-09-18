package com.bloodchain.backend.services;

import com.bloodchain.backend.requests.EmailRequest;

public interface EmailService {
    void sendEmail(EmailRequest emailRequest);

    void sendAccountCreationEmail(EmailRequest emailRequest);
}
