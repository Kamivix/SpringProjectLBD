package com.example.springprojectlbd.dto;

import com.example.springprojectlbd.entity.UserStory;

import java.sql.Timestamp;
import java.util.Set;

public class SprintDto {

    private Long id;
    private String sprintName;
    private Timestamp startTime;
    private Timestamp endTime;
    private String description;
    private String status;

    private Set<UserStoryDto> userStories;

    public SprintDto(Long id, String sprintName, Timestamp startTime, Timestamp endTime, String description, String status) {
        this.id = id;
        this.sprintName = sprintName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<UserStoryDto> getUserStories() {
        return userStories;
    }

    public void setUserStories(Set<UserStoryDto> userStories) {
        this.userStories = userStories;
    }
}


