package com.gradi.app.group.model;

import com.gradi.app.user.model.UserEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users_groups")
public class UserGroupEntity implements Serializable {
    @EmbeddedId
    UserGroupKey id;

    public UserGroupEntity(UserEntity user, GroupEntity group) {
        this.id=new UserGroupKey(user.getId(), group.getId());
    }

    public UserGroupEntity() {

    }

    public UserGroupEntity(UserGroupKey id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "UserGroupEntity{" +
                "id=" + id ;
    }

    public UserGroupKey getId() {
        return id;
    }
}
