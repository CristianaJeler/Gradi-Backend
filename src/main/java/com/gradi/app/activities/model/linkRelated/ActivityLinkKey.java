package com.gradi.app.activities.model.linkRelated;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ActivityLinkKey implements Serializable {
    @Column(name = "activity_id")
    private String activityId;
    @Column(name = "link_id")
    private String linkId;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public ActivityLinkKey() {
    }

    public ActivityLinkKey(String activityId, String linkId) {
        this.activityId = activityId;
        this.linkId = linkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityLinkKey that = (ActivityLinkKey) o;
        return Objects.equals(activityId, that.activityId) && Objects.equals(linkId, that.linkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, linkId);
    }
}
