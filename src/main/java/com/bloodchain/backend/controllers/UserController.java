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

import com.bloodchain.backend.models.Users;
import com.bloodchain.backend.requests.UserAddRequest;
import com.bloodchain.backend.requests.UserEditRequest;
import com.bloodchain.backend.responses.UserAddResponse;
import com.bloodchain.backend.responses.UserDeleteResponse;
import com.bloodchain.backend.responses.UserEditResponse;
import com.bloodchain.backend.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserAddResponse> addUser(@RequestBody UserAddRequest userAddRequest) {
        return ResponseEntity.ok(userService.addUser(userAddRequest));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Users>> findAll() {
        return ResponseEntity.ok(userService.findUsers());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Users> findById(@PathVariable("id") Integer userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @GetMapping("/findByCin/{cin}")
    public ResponseEntity<Users> findByCin(@PathVariable("cin") String cin) {
        return ResponseEntity.ok(userService.findUserByCin(cin));
    }

    @PutMapping("/edit")
    public ResponseEntity<UserEditResponse> editDonationCenter(
            @RequestBody UserEditRequest userEditRequest) {
        return ResponseEntity.ok(userService.editUser(userEditRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDeleteResponse> deleteUser(@PathVariable("id") Integer userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

}
