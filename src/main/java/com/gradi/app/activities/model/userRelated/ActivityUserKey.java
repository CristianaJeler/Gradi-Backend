package com.gradi.app.activities.model.userRelated;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ActivityUserKey implements Serializable {
    @Column(name="activity_id")
    private String activityId;

    @Column(name="user_id")
    private String userId;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ActivityUserKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityUserKey that = (ActivityUserKey) o;
        return Objects.equals(activityId, that.activityId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, userId);
    }

    public ActivityUserKey(String activityId, String userId) {
        this.activityId = activityId;
        this.userId = userId;
    }
}
