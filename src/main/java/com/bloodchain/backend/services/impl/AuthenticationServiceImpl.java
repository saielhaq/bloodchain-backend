package com.bloodchain.backend.services.impl;

// import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bloodchain.backend.config.JwtService;
// import com.bloodchain.backend.models.ERole;
import com.bloodchain.backend.models.Roles;
import com.bloodchain.backend.models.Users;
import com.bloodchain.backend.repository.RolesRepository;
import com.bloodchain.backend.repository.UserRepository;
import com.bloodchain.backend.requests.AuthenticationRequest;
import com.bloodchain.backend.requests.RegisterRequest;
import com.bloodchain.backend.responses.AuthenticationResponse;
import com.bloodchain.backend.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final RolesRepository rolesRepository;

        private final AuthenticationManager authenticationManager;

        public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                        JwtService jwtService, RolesRepository rolesRepository,
                        AuthenticationManager authenticationManager) {
                this.userRepository = userRepository;
                this.passwordEncoder = passwordEncoder;
                this.jwtService = jwtService;
                this.rolesRepository = rolesRepository;
                this.authenticationManager = authenticationManager;
        }

        public AuthenticationResponse register(RegisterRequest registerRequest) {
                Set<Roles> eRoles = registerRequest.getRoles().stream()
                                .map(eRole -> rolesRepository.findByName(eRole.name()))
                                .collect(Collectors.toSet());
                /*
                 * Set<Roles> eRoles = registerRequest.getRoles().stream().map(role -> {
                 * return rolesRepository.findByName(role);
                 * }).collect(Collectors.toSet());
                 */
                var user = new Users();
                user.setCin(registerRequest.getCin().toLowerCase());
                user.setFirstname(registerRequest.getFirstname());
                user.setLastname(registerRequest.getLastname());
                user.setEmail(registerRequest.getEmail());
                user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
                // user.setRoles(eRoles);
                for (Roles role : eRoles) {
                        if (!user.getRoles().contains(role)) {
                                user.getRoles().add(role);
                        }
                }

                user.setRoles(eRoles);
                userRepository.save(user);
                var jwtToken = jwtService.generateToken(user);
                return new AuthenticationResponse(jwtToken);
        }

        public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                authenticationRequest.getEmail(),
                                                authenticationRequest.getPassword()));
                var user = userRepository.findByEmail(authenticationRequest.getEmail())
                                .orElseThrow(() -> new UsernameNotFoundException(
                                                "User not found with email: " + authenticationRequest.getEmail()));
                var jwtToken = jwtService.generateToken(user);
                return new AuthenticationResponse(jwtToken);
        }

}