package com.gradi.app.activities.model.linkRelated;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "activities_links")
public class ActivityLinkEntity implements Serializable {
    @EmbeddedId
    ActivityLinkKey id;

    public ActivityLinkKey getId() {
        return id;
    }

    public void setId(ActivityLinkKey id) {
        this.id = id;
    }

    public ActivityLinkEntity() {
    }

    public ActivityLinkEntity(String  activityId, String linkId) {
        this.id = new ActivityLinkKey(activityId, linkId);
    }
}
