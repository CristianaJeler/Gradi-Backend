package com.gradi.app.user.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gradi.app.group.model.GroupEntity;
import com.gradi.app.group.model.UserGroupEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Data
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "user_id", columnDefinition = "varchar")
    private String id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "verified")
    private boolean verified;
    @Column(name = "status")
    private String status;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "token")
    private String token;
    @Column(name = "phone")
    private String phone;
    @Column(name = "kindergarten")
    private String kindergarten;
    @Column(name = "description")
    private String description;

    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "picture")
    private byte[] picture;


//    public Set<UserGroupEntity> getUsersGroups() {
//        return usersGroups;
//    }

//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY)
//    @JoinTable(name = "users_groups")
//    @JoinColumn(name = "user_id")
//    Set<UserGroupEntity> usersGroups;


//    @JsonIgnore
//    public void addGroupToUser(UserGroupEntity userGroupEntity){
//        if(usersGroups==null) usersGroups=new HashSet<>();
//        usersGroups.add(userGroupEntity);
//    }


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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserEntity(String firstName, String lastName, String email, String status, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.verified = false;
        this.status = status;
        this.username = username;
        this.password = password;
    }

    public UserEntity() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public boolean isVerified() {
        return verified;
    }

    public String getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", verified=" + verified +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", phone='" + phone + '\'' +
                ", kindergarten='" + kindergarten + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
