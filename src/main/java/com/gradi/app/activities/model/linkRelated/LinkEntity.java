package com.gradi.app.activities.model.linkRelated;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "links")
public class LinkEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "link_id", columnDefinition = "varchar")
    private String id;

    @Column(name = "link")
    private String link;

    @Column(name = "description")
    private String description;

    public LinkEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkEntity(String link, String description) {
        this.link = link;
        this.description = description;
    }
}
