package com.gradi.app.activities.service;

import com.gradi.app.activities.model.ActivityBody;
import com.gradi.app.activities.model.ActivityDetailsEntity;
import com.gradi.app.activities.model.answerRelated.AnswerBody;
import com.gradi.app.activities.model.answerRelated.AnswerEntity;

import java.util.List;

public interface ActivityServiceInterface {
    void addNewActivity(ActivityBody activity);

    List<ActivityDetailsEntity> getCurrentActivities(String username, String groupId);

    void addNewAnswer(AnswerBody answer, String token);

    List<AnswerBody> getAnswers(String activityId);
    List<ActivityDetailsEntity> getGroupActivities(String groupId);
}
