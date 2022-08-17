package com.example.springprojectlbd.services;

import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.event.UserStoryCreatedEvent;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SprintService {
    Set<UserStory> getUserStoryList(long id);
    Optional<List<Sprint>> getSprintRealizedBetween(Timestamp begin, Timestamp end);
    Optional<Integer> countValue(Long id);
    void changeDescriptionInSprint(Long id);
    void updateStatus(Long id, Sprint.StatusType statusType);
    void handleAddStoryEvent(UserStoryCreatedEvent event);

    void saveNewUserStory(Long id);

}
