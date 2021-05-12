package com.gradi.app.activities.model.mediaRelated;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ActivityMediaKey implements Serializable {
    @Column(name="activity_id")
    private String activityId;
    @Column(name="media_id")
    private String mediaId;

    public ActivityMediaKey() {
    }

    public ActivityMediaKey(String activityId, String mediaId) {
        this.activityId = activityId;
        this.mediaId = mediaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityMediaKey that = (ActivityMediaKey) o;
        return Objects.equals(activityId, that.activityId) && Objects.equals(mediaId, that.mediaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, mediaId);
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
