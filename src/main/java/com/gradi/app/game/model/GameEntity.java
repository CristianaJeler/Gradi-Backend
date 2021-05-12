package com.gradi.app.game.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "games")
public class GameEntity implements Serializable {
    @Id
    @Column(name = "game_id", columnDefinition = "varchar")
    private String id;
    @Column(name="full_description")
    private String fullDescription;
    @Column(name="short_description")
    private String shortDescription;
    @Column(name="name")
    private String name;
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name="picture")
    private byte[] picture;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Column(name = "field")
    private String field;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
