package com.gradi.app.badges.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name="badges")
public class BadgeEntity implements Serializable {
    @Id
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "badge_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "content")
    private byte[] content;

    public BadgeEntity() {
    }

    public BadgeEntity(String name, byte[] content) {
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
