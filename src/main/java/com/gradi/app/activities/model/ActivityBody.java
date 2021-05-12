package com.gradi.app.activities.model;

import java.io.Serializable;
import java.util.List;

public class ActivityBody implements Serializable {
    private ActivityDetailsEntity activity;
    private List<String> members;

    public ActivityDetailsEntity getActivity() {
        return activity;
    }

    public void setActivity(ActivityDetailsEntity activity) {
        this.activity = activity;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
