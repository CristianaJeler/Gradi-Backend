package com.gradi.app.authentication.jwt;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyToken implements Serializable {
    private String token;
    private String userType;

    public MyToken(String token, String userType) {
        this.token = token;
        this.userType = userType;
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
