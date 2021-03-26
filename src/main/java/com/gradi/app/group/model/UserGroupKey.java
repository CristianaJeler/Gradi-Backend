package com.gradi.app.group.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserGroupKey implements Serializable {
    @Column(name="user_id")
    String userId;
    @Column(name="group_id")
    String groupId;

    public UserGroupKey() {
    }

    public UserGroupKey(String userId, String groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGroupKey that = (UserGroupKey) o;
        return userId.equals(that.userId) && groupId.equals(that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, groupId);
    }

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }
}
