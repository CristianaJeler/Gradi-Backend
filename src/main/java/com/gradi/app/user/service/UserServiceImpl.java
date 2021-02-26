package com.gradi.app.user.service;

import com.gradi.app.user.model.UserEntity;
import com.gradi.app.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInterface{
    @Autowired
    UserRepository userRepository;
    @Override
    public void setToken(String token, String username) {
        userRepository.setToken(token, username);
    }

    @Override
    public String getUserTypeFromJWT(String jwt) {
        return userRepository.findUserEntityByToken(jwt).getStatus();
    }
}
