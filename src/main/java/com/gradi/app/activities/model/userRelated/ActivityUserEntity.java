package com.gradi.app.activities.model.userRelated;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users_activities")
public class ActivityUserEntity {
    @EmbeddedId
    ActivityUserKey id;

    public ActivityUserKey getId() {
        return id;
    }

    public void setId(ActivityUserKey id) {
        this.id = id;
    }

    public ActivityUserEntity() {
    }

    public ActivityUserEntity(String activityId, String memberId) {
        this.id = new ActivityUserKey(activityId, memberId);
    }
}
