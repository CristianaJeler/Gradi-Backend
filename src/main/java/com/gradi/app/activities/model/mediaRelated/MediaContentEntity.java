package com.gradi.app.activities.model.mediaRelated;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "media")
public class MediaContentEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "media_id", columnDefinition = "varchar")
    private String id;

    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name="content")
    private byte[] content;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Column(name = "content_type")
    private String contentType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public MediaContentEntity() {
    }

    public MediaContentEntity(byte[] content, String contentType) {
        this.content = content;
        this.contentType=contentType;
    }

    public MediaContentEntity(String id, byte[] content) {
        this.id = id;
        this.content = content;
    }
}
