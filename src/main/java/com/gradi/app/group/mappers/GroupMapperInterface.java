package com.gradi.app.group.mappers;

import com.gradi.app.group.dtos.GroupDTO;
import com.gradi.app.group.model.GroupEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapperInterface {
    GroupEntity mapToGroupEntity(GroupDTO groupDTO);
}
