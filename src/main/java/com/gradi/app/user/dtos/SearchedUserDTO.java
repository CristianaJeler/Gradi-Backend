package com.gradi.app.user.dtos;

import com.gradi.app.user.model.UserEntity;

import java.io.Serializable;

public class SearchedUserDTO implements Serializable {
    public SearchedUserDTO() {
    }

    public SearchedUserDTO(boolean isInGroup, UserEntity user) {
        this.isInGroup = isInGroup;
        this.firstName= user.getFirstName();
        this.lastName=user.getLastName();
        this.username=user.getUsername();
        this.img=user.getPicture();
        this.id=user.getId();
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public boolean isInGroup() {
        return isInGroup;
    }

    public void setInGroup(boolean inGroup) {
        isInGroup = inGroup;
    }

    String firstName;
    String lastName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String username;
    byte[] img;
    boolean isInGroup;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    @Override
    public String toString() {
        return "SearchedUserDTO{" +
                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", username='" + username + '\'' +
//                ", isInGroup=" + isInGroup +
                '}';
    }
}
