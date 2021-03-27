package com.gradi.app.group.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gradi.app.user.model.UserEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    @Column(name = "members_no")
    private Integer membersNo;

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
        this.membersNo = 1;
    }

    public GroupEntity() {

    }

//    @OneToMany(cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY)
//    @JsonIgnore
//    @JoinTable(name = "users_groups")
//    @JoinColumn(name = "group_id")
//    Set<UserGroupEntity> usersGroups;

//    @JsonIgnore
//    public void addUserToGroup(UserGroupEntity userGroupEntity){
//        if(usersGroups==null) usersGroups=new HashSet<>();
//        usersGroups.add(userGroupEntity);
//    }


    @Override
    public String toString() {
        return "GroupEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", membersNo=" + membersNo +
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

    public Integer getMembersNo() {
        return membersNo;
    }

    public void setMembersNo(Integer membersNo) {
        this.membersNo = membersNo;
    }

//    public Set<UserGroupEntity> getUsersGroups() {
//        return usersGroups;
//    }
//
//    public void setUsersGroups(Set<UserGroupEntity> usersGroups) {
//        this.usersGroups = usersGroups;
//    }
}
