package com.gradi.app.authentication.service;


import com.gradi.app.user.dtos.UserEntityDTO;
import com.gradi.app.user.dtos.UserSignupDTO;

public interface AuthServiceInterface {
        UserEntityDTO signup(UserSignupDTO user);
}
