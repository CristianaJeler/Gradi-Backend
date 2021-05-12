package com.gradi.app.group.service;


import com.gradi.app.group.dtos.GroupDTO;
import com.gradi.app.group.model.GroupEntity;
import com.gradi.app.group.model.UserGroupEntity;
import com.gradi.app.group.model.UserGroupKey;
import com.gradi.app.group.repository.GroupRepository;
import com.gradi.app.group.repository.UserGroupRepository;
import com.gradi.app.user.model.UserEntity;
import com.gradi.app.group.mappers.GroupMapperInterface;
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
    GroupMapperInterface groupMapper;

    @Autowired
    UserGroupRepository userGroupRepository;

    @Override
    public void addUserGroup(UserEntity user, GroupEntity group) {
        var usrGroup=new UserGroupEntity(user, group);
        userGroupRepository.save(usrGroup);
    }

    @Override
    public Collection<GroupEntity> getUsersGroups(String id) {
        var usersGroups=userGroupRepository.getUserGroupsByUserID(id);
        var groups=new ArrayList<GroupEntity>();
        usersGroups.forEach(ug->{
            var group=groupRepository.findById(ug.getId().getGroupId());
            group.ifPresent(groups::add);
        });
        return groups;
    }

    @Override
    public GroupEntity getGroup(String id) {
        var group=groupRepository.findById(id);
        return group.orElse(null);
    }

    @Override
    public GroupEntity addNewGroup(GroupDTO group) {
        return groupRepository.save(groupMapper.mapToGroupEntity(group));
    }
}
