package com.gradi.app.activities.mappers;

import com.gradi.app.activities.model.answerRelated.ResultBody;
import com.gradi.app.activities.model.answerRelated.ResultEntity;
import org.springframework.stereotype.Component;

@Component
public class ResultMapperImpl implements ResultMapperInterface{
    @Override
    public ResultBody mapToResultBody(ResultEntity result) {
        return new ResultBody(result.getGame(), result.getResult());
    }
}
