package com.gradi.app.group.service;


import com.gradi.app.group.model.GroupEntity;
import com.gradi.app.group.model.UserGroupEntity;
import com.gradi.app.group.repository.GroupRepository;
import com.gradi.app.group.repository.UserGroupRepository;
import com.gradi.app.user.model.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupServiceInterface{
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserGroupRepository userGroupRepository;

    @Override
    public void addUserGroup(UserEntity user, GroupEntity group) {
        var usrGroup=new UserGroupEntity(user, group);
        userGroupRepository.save(usrGroup);
    }

    @Override
    public Collection<GroupEntity> getUsersGroups(String id) {
        var usersGroups=userGroupRepository.getUsersGroups(id);
        var groups=new ArrayList<GroupEntity>();
        usersGroups.forEach(ug->{
            var group=groupRepository.findById(ug.getId().getGroupId());
            group.ifPresent(groups::add);
        });
        return groups;
    }

    @Override
    public GroupEntity addNewGroup(String name) {
        return groupRepository.save(new GroupEntity(name));
    }
}
