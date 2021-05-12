package com.gradi.app.group.mappers;

import com.gradi.app.group.dtos.GroupDTO;
import com.gradi.app.group.model.GroupEntity;
import org.springframework.stereotype.Component;

@Component
public class GroupMapperImpl implements GroupMapperInterface{
    @Override
    public GroupEntity mapToGroupEntity(GroupDTO groupDTO) {
        return new GroupEntity(groupDTO.getId(),groupDTO.getName(), groupDTO.getImg());
    }
}
