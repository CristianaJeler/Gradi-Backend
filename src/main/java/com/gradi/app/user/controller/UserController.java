package com.gradi.app.user.controller;

import com.gradi.app.apiResponse.ApiResponse;
import com.gradi.app.authentication.jwt.JwtValues;
import com.gradi.app.user.dtos.PasswordChangeDTO;
import com.gradi.app.user.dtos.ProfilePictureDTO;
import com.gradi.app.user.dtos.SearchedUserDTO;
import com.gradi.app.user.dtos.UserEntityDTO;
import com.gradi.app.user.service.UserServiceInterface;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/gradi/users")
public class UserController {
    @Autowired
    UserServiceInterface userService;

    @Autowired
    JwtValues jwtValues;

    @PutMapping(value = "/profilePic")
    public ResponseEntity<ProfilePictureDTO> updateProfilePic(@RequestBody ProfilePictureDTO picture, HttpServletRequest request) {
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1];
        try {
            userService.updateProfilePic(picture.getPicture(), token);
        } catch (SQLException | UnsupportedEncodingException throwables) {
            System.out.println("ERROR");
        }
        return ResponseEntity.ok(picture);
    }

    @GetMapping(value = "/details")
    public ResponseEntity<UserEntityDTO> getUserDetails(HttpServletRequest request) {
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1].trim();
        var user = userService.getUserDTOByToken(token);
        return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/details")
    public ResponseEntity<UserEntityDTO> updateUserDetails(@RequestBody UserEntityDTO user, HttpServletRequest request) {
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1].trim();
        var userUpdated = userService.updateProfileDetails(user, token);
        return ResponseEntity.ok(userUpdated);
    }

    @PutMapping(value = "/pass")
    public ResponseEntity<ApiResponse> updateUserPassword(@RequestBody PasswordChangeDTO oldAndNewPswd, HttpServletRequest request) {
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1].trim();
        try {
            userService.updateUserPassword(oldAndNewPswd, token);
            return ResponseEntity.ok(new ApiResponse(null, true));
        } catch (ServiceException ex) {
            return ResponseEntity.ok(new ApiResponse(ex.getMessage(), false));
        }
    }

    @GetMapping(value = "/{searchCriteria}/{groupID}/{page}&{size}")
    public ResponseEntity<Collection<SearchedUserDTO>> searchUsers(@PathVariable String searchCriteria,
                                                                   @PathVariable String groupID,
                                                                   @PathVariable Integer page,
                                                                   @PathVariable Integer size) {
        var searchedUsers=userService.searchUsers(searchCriteria, groupID, page, size);
        System.out.println(searchedUsers);
        return ResponseEntity.ok(searchedUsers);
    }

    @PutMapping(value = "/{memberID}/{groupID}")
    public ResponseEntity<?> addMemberToGroup(@PathVariable String groupID, @PathVariable String memberID) {
        userService.addMemberToGroup(groupID, memberID);
        return ResponseEntity.ok(new ApiResponse("", true));
    }

    @DeleteMapping(value = "/{memberID}/{groupID}")
    public ResponseEntity<?> deleteMemberFromGroup(@PathVariable String groupID, @PathVariable String memberID) {
        userService.deleteMemberFromGroup(groupID, memberID);
        return ResponseEntity.ok(new ApiResponse("", true));
    }

    @GetMapping(value = "/{groupID}")
    public ResponseEntity<?> fetchGroupMembers(@PathVariable String groupID) {
        var usersInGroup=userService.fetchUsersFromGroup(groupID);
        return ResponseEntity.ok(usersInGroup);
    }
}
