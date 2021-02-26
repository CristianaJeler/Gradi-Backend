package com.gradi.app.authentication.service;


import com.gradi.app.user.model.UserEntity;
import com.gradi.app.user.model.UserEntityDTO;
import com.gradi.app.user.model.UserLoginDTO;
import com.gradi.app.user.model.UserSignupDTO;

public interface AuthServiceInterface {
        UserEntityDTO signup(UserSignupDTO user);
        UserEntity login(UserLoginDTO user);
}
