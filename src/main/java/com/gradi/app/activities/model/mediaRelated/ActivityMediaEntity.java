package com.gradi.app.activities.model.mediaRelated;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "activities_media")
public class ActivityMediaEntity implements Serializable {
    @EmbeddedId
    ActivityMediaKey id;

    public ActivityMediaKey getId() {
        return id;
    }

    public void setId(ActivityMediaKey id) {
        this.id = id;
    }

    public ActivityMediaEntity() {
    }

    public ActivityMediaEntity(String activityId, String mediaId) {
        this.id = new ActivityMediaKey(activityId,mediaId);
    }
}
