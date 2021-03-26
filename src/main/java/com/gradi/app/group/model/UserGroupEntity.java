package com.gradi.app.group.model;

import com.gradi.app.user.model.UserEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users_groups")
public class UserGroupEntity implements Serializable {
    @EmbeddedId
    UserGroupKey id;

//    @ManyToOne
//    @MapsId("userId")
//    @JoinColumn(name = "user_id")
//    UserEntity user;

//    @ManyToOne
//    @MapsId("groupId")
//    @JoinColumn(name="group_id")
//    GroupEntity group;

    public UserGroupEntity(UserEntity user, GroupEntity group) {
//        this.user = user;
//        this.group = group;
        this.id=new UserGroupKey(user.getId(), group.getId());
    }

    public UserGroupEntity() {

    }

//    public UserEntity getUser() {
//        return user;
//    }
//
//    public void setUser(UserEntity user) {
//        this.user = user;
//    }
//
//    public GroupEntity getGroup() {
//        return group;
//    }

    @Override
    public String toString() {
        return "UserGroupEntity{" +
                "id=" + id ;
//                ", user=" + user +
//                ", group=" + group +
//                '}';
    }

    public UserGroupKey getId() {
        return id;
    }
}
