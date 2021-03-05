package com.gradi.app.user.controller;

import com.gradi.app.apiResponse.ApiResponse;
import com.gradi.app.authentication.jwt.JwtValues;
import com.gradi.app.user.DTOs.PasswordChangeDTO;
import com.gradi.app.user.DTOs.ProfilePictureDTO;
import com.gradi.app.user.DTOs.UserEntityDTO;
import com.gradi.app.user.service.UserServiceInterface;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

@RestController
@CrossOrigin
@RequestMapping("/gradi/users")
public class UserController {
    @Autowired
    UserServiceInterface userService;
    @Autowired
    JwtValues jwtValues;

    @RequestMapping(value = "/profilePic", method = RequestMethod.PUT)
    ResponseEntity<?> updateProfilePic(@RequestBody ProfilePictureDTO picture, HttpServletRequest request) {
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1];
        try {
            userService.updateProfilePic(picture.getPicture(), token);
        } catch (SQLException | UnsupportedEncodingException throwables) {
            System.out.println("ERROR");
        }
        return ResponseEntity.ok(picture);
    }

    @GetMapping(value = "/details")
    ResponseEntity<?> getUserDetails(HttpServletRequest request) {
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1].trim();
        var user=userService.getUserByToken(token);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/details", method = RequestMethod.PUT)
    ResponseEntity<?> updateUserDetails(@RequestBody UserEntityDTO user,HttpServletRequest request) {
        System.out.println(user);
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1].trim();
        var userUpdated=userService.updateProfileDetails(user,token);
        return ResponseEntity.ok(userUpdated);
    }

    @RequestMapping(value = "/pass", method = RequestMethod.PUT)
    ResponseEntity<?> updateUserPassword(@RequestBody PasswordChangeDTO oldAndNewPswd, HttpServletRequest request) {
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1].trim();
        try{
            userService.updateUserPassword(oldAndNewPswd,token);
            return new ResponseEntity(new ApiResponse(null,true),HttpStatus.OK);
        }catch(ServiceException ex){
            return new ResponseEntity(new ApiResponse(ex.getMessage(),false),HttpStatus.OK);
        }
    }
}
