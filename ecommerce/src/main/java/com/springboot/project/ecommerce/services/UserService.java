package com.springboot.project.ecommerce.services;

import com.springboot.project.ecommerce.dto.LoginRequest;
import com.springboot.project.ecommerce.dto.SignUpRequest;
import com.springboot.project.ecommerce.entities.UserEntity;
import com.springboot.project.ecommerce.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public SignUpRequest createNewUser(SignUpRequest signUpRequest) {
        UserEntity newUser = modelMapper.map(signUpRequest, UserEntity.class);
        UserEntity savedUser = userRepository.save(newUser);
        return modelMapper.map(savedUser, SignUpRequest.class);
    }

    public LoginRequest loginExistingUser(LoginRequest loginRequest) {
        UserEntity user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password!"));

        if(!user.getUserPassword().equals(loginRequest.getUserPassword())) {
            throw new  RuntimeException("Invalid user or password");
        }
        return modelMapper.map(user, LoginRequest.class);
    }
}
