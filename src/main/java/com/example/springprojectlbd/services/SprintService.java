package com.example.springprojectlbd.services;

import com.example.springprojectlbd.dto.SprintDto;
import com.example.springprojectlbd.dto.SprintDtoSlim;
import com.example.springprojectlbd.dto.UserStoryDto;
import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.event.UserStoryCreatedEvent;

import java.sql.SQLDataException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SprintService {
    Set<UserStoryDto> getUserStoryList(long id);
   List<SprintDtoSlim> getSprintRealizedBetween(Timestamp begin, Timestamp end);
    Integer countValue(Long id);
    void changeDescriptionInSprint(Long id,String description);
    void updateStatus(Long id, Sprint.StatusType statusType);
    void handleAddStoryEvent(UserStoryCreatedEvent event);
    List<SprintDto> getSprints(Boolean listOrNot);
    void saveNewUserStory(Long id,UserStoryDto userStoryDto);
    void saveData(String name, Timestamp dataStart, Timestamp dataEnd, String description, Sprint.StatusType status) throws SQLDataException;
    void saveNewSprint(SprintDto sprintDto);
}
