package com.gradi.app.authentication.jwt;

import lombok.Data;

import java.io.Serializable;
import java.util.Base64;

@Data
public class LoggedInUserData implements Serializable {
    private String token;
    private String userType;
    private String firstName;
    private String lastName;
    private String picture;
    private String phone;
    private String kindergarten;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getKindergarten() {
        return kindergarten;
    }

    public void setKindergarten(String kindergarten) {
        this.kindergarten = kindergarten;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public LoggedInUserData(String token, String userType, String firstName, String lastName, byte[] picture) {
        this.token = token;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        if(picture!=null)
            this.picture= Base64.getEncoder().encodeToString(picture);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
