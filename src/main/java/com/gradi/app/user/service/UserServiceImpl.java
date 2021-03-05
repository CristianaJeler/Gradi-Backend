package com.gradi.app.user.service;

import com.gradi.app.authentication.jwt.LoggedInUserData;
import com.gradi.app.user.DTOs.PasswordChangeDTO;
import com.gradi.app.user.DTOs.UserEntityDTO;
import com.gradi.app.user.repository.UserRepository;
import com.gradi.app.utilities.mappers.UsersMapperInterface;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInterface{
    @Autowired
    UserRepository userRepository;

    @Autowired
    UsersMapperInterface usersMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void setToken(String token, String username) {
        userRepository.setToken(token, username);
    }

    @Override
    public LoggedInUserData getLoggedInUserFromJWT(String jwt) {
        return usersMapper.mapToLoggedInUserData(userRepository.findUserEntityByToken(jwt));
    }


    @Override
    public void updateProfilePic(String picture, String token) {
           var decodedBase64= Base64.getDecoder().decode(picture.substring(picture.indexOf(",") + 1).getBytes(StandardCharsets.UTF_8));
           userRepository.updateProfilePic(decodedBase64,token.trim());

    }


    @Override
    public UserEntityDTO getUserByToken(String token) {
        return usersMapper.mapToUserEntityDTO(userRepository.findUserEntityByToken(token));
    }

    @Override
    public UserEntityDTO updateProfileDetails(UserEntityDTO user, String token) {
        var dbUser=userRepository.findUserEntityByToken(token);
        if(dbUser==null) throw new ServiceException("Unexisting user!");
        else {
            var id=dbUser.getId();
            if (user.getFirstName() != null && user.getFirstName().length() != 0)
                userRepository.updateFirstName(user.getFirstName(), id);
            else user.setFirstName(dbUser.getFirstName());

            if (user.getLastName() != null && user.getLastName().length() != 0)
                userRepository.updateLastName(user.getLastName(), id);
            else user.setLastName(dbUser.getLastName());

            userRepository.updateKindergarten(user.getKindergarten(), id);
            userRepository.updatePhone(user.getPhone(), id);

            return user;
        }
    }

    @Override
    public void updateUserPassword(PasswordChangeDTO oldAndNewPswd, String token) {
        var dbUser=userRepository.findUserEntityByToken(token);
        if(dbUser!=null){
            String oldPassword=oldAndNewPswd.getOldPassword();
            String newPassword=passwordEncoder.encode(oldAndNewPswd.getNewPassword());
            System.out.println(dbUser.getPassword()+"\n"+oldPassword);
            if(passwordEncoder.matches(oldPassword, dbUser.getPassword())){
                userRepository.updatePassword(dbUser.getPassword(),newPassword,dbUser.getId());
            }else{
                throw new ServiceException("Parolă incorectă!");
            }
        }else{
            throw new ServiceException("Utilizator neautorizat!");
        }
    }
}
