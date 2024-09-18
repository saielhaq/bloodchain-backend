package com.bloodchain.backend.services;

import org.springframework.stereotype.Service;

import com.bloodchain.backend.requests.AuthenticationRequest;
import com.bloodchain.backend.requests.RegisterRequest;
import com.bloodchain.backend.responses.AuthenticationResponse;

@Service
public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}
