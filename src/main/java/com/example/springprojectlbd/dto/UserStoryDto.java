package com.example.springprojectlbd.dto;

import com.example.springprojectlbd.entity.Sprint;
import java.util.HashSet;
import java.util.Set;

public class UserStoryDto
{

    private Long id;
    private String userStoryName;
    private String description;
    private int countOfStoryPoint;
    private String status;

    private Set<SprintDto> sprints= new HashSet<>();

    public UserStoryDto(Long id, String userStoryName, String description, int countOfStoryPoint, String status) {
        this.id = id;
        this.userStoryName = userStoryName;
        this.description = description;
        this.countOfStoryPoint = countOfStoryPoint;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<SprintDto> getSprints() {
        return sprints;
    }

    public void setSprints(Set<SprintDto> sprints) {
        this.sprints = sprints;
    }
}
