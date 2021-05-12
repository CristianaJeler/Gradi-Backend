package com.gradi.app.activities.model.answerRelated;

import com.gradi.app.activities.model.mediaRelated.MediaDTO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AnswerBody implements Serializable {
    private List<MediaDTO> photos;
    private String groupId;
    private String memberName;
    private List<ResultBody> gameResults;
    private String activityId;


    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerBody that = (AnswerBody) o;
        return Objects.equals(photos, that.photos) && Objects.equals(groupId, that.groupId) && Objects.equals(memberName, that.memberName) && Objects.equals(gameResults, that.gameResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photos, groupId, memberName, gameResults);
    }

    public List<MediaDTO> getPhotos() {
        return photos;
    }

    public void setPhotos(List<MediaDTO> photos) {
        this.photos = photos;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public List<ResultBody> getGameResults() {
        return gameResults;
    }

    public void setGameResults(List<ResultBody> gameResults) {
        this.gameResults = gameResults;
    }

    public AnswerBody() {
    }

    public AnswerBody(String activityId,List<MediaDTO> photos, String groupId, String memberName, List<ResultBody> gameResults) {
        this.photos = photos;
        this.groupId = groupId;
        this.memberName = memberName;
        this.gameResults = gameResults;
        this.activityId=activityId;
    }

    @Override
    public String toString() {
        return "AnswerBody{" +
                "photos=" + photos +
                ", groupId='" + groupId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", gameResults=" + gameResults +
                ", activityId='" + activityId + '\'' +
                '}';
    }
}
