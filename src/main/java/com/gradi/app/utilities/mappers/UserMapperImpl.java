package com.gradi.app.utilities.mappers;

import com.gradi.app.user.model.UserEntity;
import com.gradi.app.user.model.UserEntityDTO;
import com.gradi.app.user.model.UserSignupDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UsersMapperInterface{
    @Override
    public UserEntityDTO mapToUserEntityDTO(UserEntity user) {
        return new UserEntityDTO(user.getFirstName(), user.getLastName(),user.getEmail(),user.getStatus(),user.getUsername());
    }

    @Override
    public UserEntity mapToUserEntity(UserSignupDTO user) {
        return new UserEntity(user.getFirstName(), user.getLastName(), user.getEmail(), user.getStatus(), user.getUsername(), user.getPassword());
    }


}
