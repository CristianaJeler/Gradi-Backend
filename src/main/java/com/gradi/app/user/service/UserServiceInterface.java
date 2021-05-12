package com.gradi.app.user.service;


import com.gradi.app.authentication.jwt.LoggedInUserData;
import com.gradi.app.user.dtos.PasswordChangeDTO;
import com.gradi.app.user.dtos.SearchedUserDTO;
import com.gradi.app.user.dtos.UserEntityDTO;
import com.gradi.app.user.model.UserEntity;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Collection;

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
    UserEntityDTO getUserDTOByToken(String token);

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

    /**
     *
     * @param token
     * @return
     */
    UserEntity getUserEntityByToken(String token);


    /**
     *
     * @param searchCriteria
     * @param groupID
     * @param page
     * @param size
     * @return
     */
    Collection<SearchedUserDTO> searchUsers(String searchCriteria, String groupID, Integer page, Integer size);

    void addMemberToGroup(String groupID, String memberID);

    void deleteMemberFromGroup(String groupID, String memberID);

    Collection<SearchedUserDTO> fetchUsersFromGroup(String groupID);
}
