package com.bloodchain.backend.services;

// import org.springframework.stereotype.Service;

import java.util.List;

// import org.springframework.stereotype.Service;

import com.bloodchain.backend.models.Users;
import com.bloodchain.backend.requests.UserAddRequest;
import com.bloodchain.backend.requests.UserEditRequest;
import com.bloodchain.backend.responses.UserAddResponse;
import com.bloodchain.backend.responses.UserDeleteResponse;
import com.bloodchain.backend.responses.UserEditResponse;

public interface UserService {
    UserAddResponse addUser(UserAddRequest userAddRequest);

    List<Users> findUsers();

    Users findUserById(Integer userId);

    Users findUserByCin(String cin);

    UserDeleteResponse deleteUser(Integer userId);

    UserEditResponse editUser(UserEditRequest userEditRequest);
}
