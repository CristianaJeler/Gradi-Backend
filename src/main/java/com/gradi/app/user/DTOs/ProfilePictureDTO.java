package com.gradi.app.user.DTOs;

public class ProfilePictureDTO {
    String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return picture;
    }
}
