package com.gradi.app.activities.model.mediaRelated;

import java.io.Serializable;

public class MediaDTO implements Serializable {
    private String content;
    private String contentType;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public MediaDTO(String content, String contentType) {
        this.content = content;
        this.contentType=contentType;
    }

    public MediaDTO() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
