package com.gradi.app.activities.mappers;

import com.gradi.app.activities.model.mediaRelated.MediaContentEntity;
import com.gradi.app.activities.model.mediaRelated.MediaDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MediaMapperInterface {
    MediaContentEntity mapToMediaContentEntity(MediaDTO media);
    MediaDTO mapToMediaDTO(MediaContentEntity media);
}
