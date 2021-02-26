package com.gradi.app.user.model;

import lombok.Data;

@Data
public class UserEntityDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String status;
    private String username;

    public UserEntityDTO(String firstName, String lastName, String email, String status, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                '}';
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

}
