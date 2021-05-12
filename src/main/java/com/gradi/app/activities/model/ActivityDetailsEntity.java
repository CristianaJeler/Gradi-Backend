package com.gradi.app.activities.model;

import com.gradi.app.activities.model.linkRelated.LinkEntity;
import com.gradi.app.activities.model.mediaRelated.MediaContentEntity;
import com.gradi.app.activities.model.mediaRelated.MediaDTO;
import com.gradi.app.game.model.GameEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ActivityDetailsEntity implements Serializable {
    private String id;
    private String assignedBy;
    private String dueDate;
    private String description;
    private String title;
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    private String field;
    private List<GameEntity> games;
    private List<MediaDTO> media;
    private List<LinkEntity> links;

    public ActivityDetailsEntity(String dueDate, String description, List<GameEntity> games, List<MediaDTO> media, List<LinkEntity> links) {
        this.dueDate = dueDate;
        this.description = description;
        this.games = games;
        this.media = media;
        this.links = links;
    }


    public ActivityDetailsEntity() {
    }

    public ActivityDetailsEntity(String id,String dueDate, String description, String title, String field, List<GameEntity> games, List<MediaDTO> media, List<LinkEntity> links) {
        this.id=id;
        this.dueDate = dueDate;
        this.description = description;
        this.title = title;
        this.field = field;
        this.games = games;
        this.media = media;
        this.links = links;
    }

    public ActivityDetailsEntity(String id,String dueDate, String description, String title, String field) {
        this.id=id;
        this.dueDate = dueDate;
        this.description = description;
        this.title = title;
        this.field = field;
    }

    public ActivityDetailsEntity(String assignedBy, String dueDate, String description, List<GameEntity> games, List<MediaDTO> media, List<LinkEntity> links) {
        this.assignedBy = assignedBy;
        this.dueDate = dueDate;
        this.description = description;
        this.games = games;
        this.media = media;
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GameEntity> getGames() {
        return games;
    }

    public void setGames(List<GameEntity> games) {
        this.games = games;
    }

    public List<MediaDTO> getMedia() {
        return media;
    }

    public void setMedia(List<MediaDTO> media) {
        this.media = media;
    }

    public List<LinkEntity> getLinks() {
        return links;
    }

    public void setLinks(List<LinkEntity> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "ActivityDetailsEntity{" +
                "id='" + id + '\'' +
                ", assignedBy='" + assignedBy + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", description='" + description + '\'' +
                ", games=" + games +
                ", media=" + media +
                ", links=" + links +
                '}';
    }
}
