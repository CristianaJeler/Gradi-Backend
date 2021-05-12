package com.gradi.app.group.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gradi.app.user.model.UserEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "groups")
@Data
public class GroupEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "group_id", columnDefinition = "varchar")
    private String id;
    @Column(name = "name")
    private String name;

    public GroupEntity(String id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Column(name = "img")
    private String img;

    @JsonIgnore
    public GroupEntity(String name) {
        this.name = name;
    }

    public GroupEntity() {

    }

    @Override
    public String toString() {
        return "GroupEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupEntity that = (GroupEntity) o;
        return id.equals(that.id);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
