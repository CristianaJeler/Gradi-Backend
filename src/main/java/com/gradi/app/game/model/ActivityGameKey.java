package com.gradi.app.game.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ActivityGameKey implements Serializable {
    @Column(name="activity_id")
    private String activityId;
    @Column(name="game_id")
    private String gameId;

    public ActivityGameKey(String activityId, String gameId) {
        this.activityId = activityId;
        this.gameId = gameId;
    }

    public ActivityGameKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityGameKey that = (ActivityGameKey) o;
        return Objects.equals(activityId, that.activityId) && Objects.equals(gameId, that.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, gameId);
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
