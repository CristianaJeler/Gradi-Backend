package com.gradi.app.user.service;

import com.gradi.app.user.model.UserEntity;
import com.gradi.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserServiceInterface {
    void setToken(String token, String username);

    String getUserTypeFromJWT(String jwt);
}
