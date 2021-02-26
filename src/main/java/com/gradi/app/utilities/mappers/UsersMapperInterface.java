package com.gradi.app.utilities.mappers;

import com.gradi.app.user.model.UserEntity;
import com.gradi.app.user.model.UserEntityDTO;
import com.gradi.app.user.model.UserSignupDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper(componentModel = "spring")
public interface UsersMapperInterface {
    UserEntityDTO mapToUserEntityDTO(UserEntity user);
    UserEntity mapToUserEntity(UserSignupDTO user);
}
