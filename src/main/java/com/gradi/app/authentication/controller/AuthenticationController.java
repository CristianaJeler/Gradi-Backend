package com.gradi.app.authentication.controller;

import com.gradi.app.apiResponse.ApiResponse;
import com.gradi.app.authentication.errors.ExistingCredentialsError;
import com.gradi.app.authentication.errors.InvalidCredentialsError;
import com.gradi.app.authentication.errors.LoginError;
import com.gradi.app.authentication.jwt.LoggedInUserData;
import com.gradi.app.authentication.jwt.TokenProvider;
import com.gradi.app.authentication.service.AuthServiceInterface;
import com.gradi.app.user.dtos.UserLoginDTO;
import com.gradi.app.user.dtos.UserSignupDTO;
import com.gradi.app.user.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/gradi/authentication")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    AuthServiceInterface authService;
    @Autowired
    TokenProvider tokenProvider;

    @Autowired
    UserServiceInterface userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    ResponseEntity<?> signup(@RequestBody UserSignupDTO user) {
        try{
            authService.signup(user);
            return new ResponseEntity(new ApiResponse(null,true),HttpStatus.OK);
        }catch (InvalidCredentialsError|ExistingCredentialsError ex){
            return new ResponseEntity(new ApiResponse(ex.getMessage(),false),HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    ResponseEntity<?> login(@RequestBody UserLoginDTO user) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.generateToken(authentication);
            userService.setToken(jwt, user.getUsername());
            LoggedInUserData loggedUser=userService.getLoggedInUserFromJWT(jwt);
            loggedUser.setToken(jwt);
            return ResponseEntity.ok(loggedUser);
        }catch (LoginError ex) {
            return new ResponseEntity(new ApiResponse(ex.getMessage(),false),HttpStatus.OK);
        }
    }
}