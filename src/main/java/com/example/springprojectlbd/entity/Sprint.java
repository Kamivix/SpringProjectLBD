package com.example.springprojectlbd.entity;

import javax.persistence.*;
import java.sql.Timestamp;
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

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", nullable=false)
    private StatusType status;



    @ManyToMany(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
    @JoinTable(
            name ="SPRINT_USER_STORY",
            joinColumns = @JoinColumn(name="SPRINT_ID"),
            inverseJoinColumns = @JoinColumn(name = "USERSTORY_ID")
    )

private Set<UserStory> userStories ;


    public Set<UserStory> getUserStories() {
        return userStories;
    }

    public Sprint(long id, String sprintName, Timestamp startTime, Timestamp endTime, String description, StatusType status) {
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

    public void setId(long id) {
        this.id = id;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public void setUserStories(Set<UserStory> userStories) {
        this.userStories = userStories;
    }

    public enum StatusType {
        PENDING, IN_PROGRESS, FINISHED, CANCELED
    }
}
