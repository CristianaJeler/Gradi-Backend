package com.gradi.app.authentication.jwt;

import com.gradi.app.user.model.UserEntity;
import com.gradi.app.user.model.UserLoginDTO;
import com.gradi.app.user.model.UserSignupDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import liquibase.pro.packaged.J;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenProvider {
    @Autowired
    JwtValues jwtValues;
    public String generateToken(Authentication authentication) {
        MyUserDetails userPrincipal = (MyUserDetails) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtValues.getEXPIRATION());


        ///TO DO
        return Jwts.builder()
                .setSubject(String.valueOf(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtValues.getSECRET())
                .compact();
    }


    public String extractID(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtValues.getSECRET())
                .parseClaimsJws(token)
                .getBody();

        return String.valueOf(claims.getSubject());
    }

}
