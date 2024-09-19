package com.bloodchain.backend.services.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bloodchain.backend.config.JwtService;
import com.bloodchain.backend.models.Users;
import com.bloodchain.backend.models.Roles;
import com.bloodchain.backend.repository.RolesRepository;
import com.bloodchain.backend.repository.UserRepository;
import com.bloodchain.backend.requests.UserAddRequest;
import com.bloodchain.backend.requests.UserEditRequest;
import com.bloodchain.backend.responses.UserAddResponse;
import com.bloodchain.backend.responses.UserDeleteResponse;
import com.bloodchain.backend.responses.UserEditResponse;
import com.bloodchain.backend.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final RolesRepository rolesRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
            RolesRepository rolesRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public UserAddResponse addUser(UserAddRequest userAddRequest) {
        Set<Roles> eRoles = userAddRequest.getRoles().stream()
                .map(eRole -> rolesRepository.findByName(eRole.name()))
                .collect(Collectors.toSet());
        // Set<Roles> eRoles = userAddRequest.getRoles().stream().map(role -> {
        // return rolesRepository.findByName(role.name());
        // }).collect(Collectors.toSet());
        var user = new Users();
        user.setCin(userAddRequest.getCin().toLowerCase());
        user.setFirstname(userAddRequest.getFirstname());
        user.setLastname(userAddRequest.getLastname());
        user.setEmail(userAddRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userAddRequest.getPassword()));

        for (Roles role : eRoles) {
            if (!user.getRoles().contains(role)) {
                user.getRoles().add(role);
            }
        }
        user.setRoles(eRoles);
        userRepository.save(user);
        // var jwtToken = jwtService.generateToken(user);
        return new UserAddResponse(user.getId(), user.getCin(), user.getFirstname(), user.getLastname(),
                user.getEmail(),
                userAddRequest.getPassword(), user.getRoles());

    }

    @Override
    public List<Users> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDeleteResponse deleteUser(Integer userId) {
        if (!userRepository.existsById(userId)) {
            return new UserDeleteResponse("User doesn't exist");
        }
        userRepository.deleteById(userId);
        return new UserDeleteResponse("User deleted successfully");
    }

    @Override
    public UserEditResponse editUser(UserEditRequest userEditRequest) {
        var existingUser = userRepository.findByCin(userEditRequest.getCin());
        if (existingUser == null) {
            return new UserEditResponse("User not found");
        }

        existingUser.setFirstname(userEditRequest.getFirstname());
        existingUser.setLastname(userEditRequest.getLastname());
        existingUser.setEmail(userEditRequest.getEmail());
        if (userEditRequest.getPassword() != null && !userEditRequest.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(userEditRequest.getPassword()));
        }
        existingUser.setBloodType(userEditRequest.getBloodType());
        existingUser.setLastUpdate(userEditRequest.getLastUpdate());
        existingUser.setRoles(userEditRequest.getRoles());

        try {
            userRepository.save(existingUser);
        } catch (Exception e) {
            return new UserEditResponse("Could not update user");
        }

        return new UserEditResponse("User updated successfully");
    }

    @Override
    public Users findUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Users findUserByCin(String cin) {
        return userRepository.findByCin(cin);
    }

}
