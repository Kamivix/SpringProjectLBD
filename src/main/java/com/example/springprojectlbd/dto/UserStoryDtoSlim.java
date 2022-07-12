package com.example.springprojectlbd.dto;

public class UserStoryDtoSlim {

    private Long id;
    private String userStoryName;
    private int countOfStoryPoint;
    private String status;

    public UserStoryDtoSlim(Long id, String userStoryName, int countOfStoryPoint, String status) {
        this.id = id;
        this.userStoryName = userStoryName;
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
}
