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

    public void addTo(Sprint sprint){
        sprints.add(sprint);
    }
}
