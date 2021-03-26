package com.gradi.app.utilities.mappers;

import com.gradi.app.authentication.jwt.LoggedInUserData;
import com.gradi.app.user.model.UserEntity;
import com.gradi.app.user.dtos.UserEntityDTO;
import com.gradi.app.user.dtos.UserSignupDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapperInterface {
    UserEntityDTO mapToUserEntityDTO(UserEntity user);
    UserEntity mapToUserEntity(UserSignupDTO user);
    LoggedInUserData mapToLoggedInUserData(UserEntity user);
}
