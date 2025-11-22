package com.springboot.project.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SignUpRequest {

    private String userName;
    private String email;
    private String userPassword;

}
