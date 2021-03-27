package com.gradi.app.group.service;

import com.gradi.app.group.model.GroupEntity;
import com.gradi.app.user.model.UserEntity;

import java.util.Collection;

public interface GroupServiceInterface {
    GroupEntity addNewGroup(GroupEntity group);
    void addUserGroup(UserEntity user, GroupEntity group);
    Collection<GroupEntity> getUsersGroups(String id);
}
