package com.gradi.app.authentication.controller;

import com.gradi.app.authentication.errors.ExistingCredentialsError;
import com.gradi.app.authentication.errors.InvalidCredentialsError;
import com.gradi.app.authentication.errors.LoginError;
import com.gradi.app.authentication.jwt.MyToken;
import com.gradi.app.authentication.jwt.TokenProvider;
import com.gradi.app.authentication.service.AuthServiceInterface;
import com.gradi.app.user.model.UserEntity;
import com.gradi.app.user.model.UserEntityDTO;
import com.gradi.app.user.model.UserLoginDTO;
import com.gradi.app.user.model.UserSignupDTO;
import com.gradi.app.user.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
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
            UserEntityDTO userSignedUp=authService.signup(user);
            return ResponseEntity.ok(userSignedUp);
        }catch (InvalidCredentialsError ex){
            return ResponseEntity.status(422).body(ex.getMessage());
        }catch(ExistingCredentialsError ex){
            return ResponseEntity.status(409).body(ex.getMessage());
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
            String userType=userService.getUserTypeFromJWT(jwt);
            System.out.println(userType);
            return ResponseEntity.ok(new MyToken(jwt, userType));
        }catch (LoginError ex) {
//            return ResponseEntity.status(401).body(ex.getMessage());
            return ResponseEntity.ok("LOGIN ERROR");
        }
    }
}