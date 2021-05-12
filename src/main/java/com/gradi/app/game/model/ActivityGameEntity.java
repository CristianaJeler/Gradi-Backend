package com.gradi.app.game.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "activities_games")
public class ActivityGameEntity implements Serializable {
    @EmbeddedId
    ActivityGameKey id;

    public ActivityGameEntity(String activityId, String gameId) {
        this.id = new ActivityGameKey(activityId, gameId);
    }

    public ActivityGameEntity() {
    }

    public ActivityGameKey getId() {
        return id;
    }

    public void setId(ActivityGameKey id) {
        this.id = id;
    }
}
