package com.gradi.app.activities.mappers;

import com.gradi.app.activities.model.answerRelated.ResultBody;
import com.gradi.app.activities.model.answerRelated.ResultEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ResultMapperInterface {
    ResultBody mapToResultBody(ResultEntity result);
}
