package com.gradi.app.authentication.service;


import com.gradi.app.user.DTOs.UserEntityDTO;
import com.gradi.app.user.DTOs.UserSignupDTO;

public interface AuthServiceInterface {
        UserEntityDTO signup(UserSignupDTO user);
}
