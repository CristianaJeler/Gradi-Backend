package com.gradi.app.activities.model.answerRelated;

import com.gradi.app.activities.model.linkRelated.ActivityLinkKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="answers_media")
public class AnswerMediaEntity implements Serializable {
    @EmbeddedId
    AnswerMediaKey id;

    public AnswerMediaKey getId() {
        return id;
    }

    public void setId(AnswerMediaKey id) {
        this.id = id;
    }

    public AnswerMediaEntity() {
    }

    public AnswerMediaEntity(String  answerId, String mediaId) {
        this.id = new AnswerMediaKey(mediaId,answerId);
    }

}
