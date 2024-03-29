package com.gradi.app.user.mappers;

import com.gradi.app.authentication.jwt.LoggedInUserData;
import com.gradi.app.user.model.UserEntity;
import com.gradi.app.user.dtos.UserEntityDTO;
import com.gradi.app.user.dtos.UserSignupDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UsersMapperInterface{
    @Override
    public UserEntityDTO mapToUserEntityDTO(UserEntity user) {
        return new UserEntityDTO(user.getFirstName(), user.getLastName(),user.getEmail(),user.getStatus(),user.getUsername(),user.getPhone(),user.getKindergarten(),user.getKindergarten(),user.getPicture());
    }

    @Override
    public UserEntity mapToUserEntity(UserSignupDTO user) {
        return new UserEntity(user.getFirstName(), user.getLastName(), user.getEmail(), user.getStatus(), user.getUsername(), user.getPassword());
    }

    @Override
    public LoggedInUserData mapToLoggedInUserData(UserEntity user) {
        return new LoggedInUserData(user.getToken(),user.getStatus(), user.getFirstName(), user.getLastName(), user.getPicture());
    }
}
