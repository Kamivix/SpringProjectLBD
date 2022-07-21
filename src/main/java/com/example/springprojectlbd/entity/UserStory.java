package com.example.springprojectlbd.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER_STORY")
public class UserStory {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "USERSTORYNAME")
    private String userStoryName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COUNTOFSTORYPOINT")
    private int countOfStoryPoint;

    @Column(name = "STATUS")
    private String status;



@ManyToMany(mappedBy = "userStories",fetch=FetchType.LAZY)
    Set<Sprint> sprints= new HashSet<>();

    @OneToMany(mappedBy = "userStoryLinked")
    private Set<BinaryFile> binaryFiles = new HashSet<>();
    public UserStory(long id, String userStoryName, String description, int countOfStoryPoint, String status) {
        this.id = id;
        this.userStoryName = userStoryName;
        this.description = description;
        this.countOfStoryPoint = countOfStoryPoint;
        this.status = status;
    }

    public UserStory() {
    }

    public long getId() {
        return id;
    }

    public Set<Sprint> getSprints() {
        return sprints;
    }



    public void setId(long id) {
        this.id = id;
    }

    public String getUserStoryName() {
        return userStoryName;
    }

    public void setUserStoryName(String userStoryName) {
        this.userStoryName = userStoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCountOfStoryPoint() {
        return countOfStoryPoint;
    }

    public void setCountOfStoryPoint(int countOfStoryPoint) {
        this.countOfStoryPoint = countOfStoryPoint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSprints(Set<Sprint> sprints) {
        this.sprints = sprints;
    }
}
