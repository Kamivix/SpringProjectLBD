package com.example.springprojectlbd.entity;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SPRINT")
public class Sprint {
    @Id
    @Column(name="ID", nullable=false)
    private long id;
    @Column(name="SPRINTNAME", nullable=false)
private String sprintName;
    @Column(name="STARTTIME",nullable = false)
private Timestamp startTime;
    @Column(name="ENDTIME",nullable = false)
private Timestamp endTime;
    @Column(name="DESCRIPTION")
private String description;
    @Column(name="STATUS", nullable=false)
private String status;


    public Set<UserStory> getUserStories() {
        return userStories = new HashSet<>();
    }

    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(
            name ="SPRINT_USER_STORY",
            joinColumns = @JoinColumn(name="SPRINT_ID",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "USERSTORY_ID",referencedColumnName = "ID")
    )



private Set<UserStory> userStories;

    public Set<UserStory> getuserStories(){
        return userStories;
    }
    public Sprint(long id, String sprintName, Timestamp startTime, Timestamp endTime, String description, String status) {
        this.id = id;
        this.sprintName = sprintName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.status = status;
    }

    public Sprint() {
    }

    public long getId() {
        return id;
    }

    public void addTo(UserStory userStory){
        userStories.add(userStory);
    }

}
