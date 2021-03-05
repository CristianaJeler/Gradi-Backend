package com.gradi.app.user.service;


import com.gradi.app.authentication.jwt.LoggedInUserData;
import com.gradi.app.user.DTOs.PasswordChangeDTO;
import com.gradi.app.user.DTOs.UserEntityDTO;
import org.hibernate.service.spi.ServiceException;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public interface UserServiceInterface {
    /**
     *
     * @param token
     * @param username
     */
    void setToken(String token, String username);

    /**
     *
     * @param jwt
     * @return
     */
    LoggedInUserData getLoggedInUserFromJWT(String jwt);

    /**
     *
     * @param picture
     * @param token
     * @throws SQLException
     * @throws UnsupportedEncodingException
     */
    void updateProfilePic(String picture, String token) throws SQLException, UnsupportedEncodingException;

    /**
     *
     * @param token
     * @return
     */
    UserEntityDTO getUserByToken(String token);

    /**
     *
     * @param user
     * @param token
     * @return
     */
    UserEntityDTO updateProfileDetails(UserEntityDTO user, String token);


    /**
     *
     * @param oldAndNewPswd
     * @param token
     */
    void updateUserPassword(PasswordChangeDTO oldAndNewPswd, String token);
}
