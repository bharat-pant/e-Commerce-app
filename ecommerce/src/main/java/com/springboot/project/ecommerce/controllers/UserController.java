package com.springboot.project.ecommerce.controllers;

import com.springboot.project.ecommerce.dto.LoginRequest;
import com.springboot.project.ecommerce.dto.SignUpRequest;
import com.springboot.project.ecommerce.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor

public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpRequest> createNewUser(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginRequest> loginExistingUser(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.OK).body(userService.loginExistingUser(loginRequest));
    }

}
