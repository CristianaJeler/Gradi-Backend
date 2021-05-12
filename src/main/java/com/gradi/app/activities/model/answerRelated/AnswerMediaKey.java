package com.gradi.app.activities.model.answerRelated;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AnswerMediaKey implements Serializable {
    @Column(name = "media_id")
    String media_id;

    @Column(name = "answer_id")
    String answer_id;

    public AnswerMediaKey() {
    }

    public AnswerMediaKey(String media_id, String answer_id) {
        this.media_id = media_id;
        this.answer_id = answer_id;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(String answer_id) {
        this.answer_id = answer_id;
    }
}
