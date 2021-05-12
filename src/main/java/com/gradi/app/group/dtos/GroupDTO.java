package com.gradi.app.group.dtos;

public class GroupDTO {
    private String id;
    private String name;
    private Integer membersNo;
    private String img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMembersNo() {
        return membersNo;
    }

    public void setMembersNo(Integer membersNo) {
        this.membersNo = membersNo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
