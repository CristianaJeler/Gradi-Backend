package com.gradi.app.user.DTOs;

import lombok.Data;

import java.io.Serializable;
import java.util.Base64;


@Data
public class UserEntityDTO implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String status;
    private String username;
    private String phone;
    private String kindergarten;
    private String description;
    private String picture;

    @Override
    public String toString() {
        return "UserEntityDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", kindergarten='" + kindergarten + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    public UserEntityDTO(String firstName, String lastName, String email, String status, String username, String phone, String kindergarten, String description, byte[] picture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.username = username;
        this.phone = phone;
        this.kindergarten = kindergarten;
        this.description = description;
        if(picture==null) this.picture = null;
        else this.picture= Base64.getEncoder().encodeToString(picture);
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    public String getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
