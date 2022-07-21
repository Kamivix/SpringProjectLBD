package com.example.springprojectlbd.event;

public class UserStoryCreatedEvent {

    Long userStoryId;

    public Long getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(Long userStoryId) {
        this.userStoryId = userStoryId;
    }

    public UserStoryCreatedEvent(Long userStoryId) {
        this.userStoryId = userStoryId;
    }
}
