package com.gradi.app.activities.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "activities")
public class ActivityEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "activity_id", columnDefinition = "varchar")
    private String id;
    @Column(name = "description")
    private String description;
    @Column(name = "due_date")
    private String dueDate;
    @Column(name="title")
    private String title;
    @Column(name="group_id")
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

    @Column(name="field")
    private String field;

    public ActivityEntity(String groupId,String description, String dueDate, String field, String title) {
        this.description = description;
        this.dueDate = dueDate;
        this.field=field;
        this.title=title;
        this.groupId=groupId;
    }

    public ActivityEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
