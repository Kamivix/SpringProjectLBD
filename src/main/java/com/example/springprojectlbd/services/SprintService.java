package com.example.springprojectlbd.services;

import com.example.springprojectlbd.dto.SprintDto;
import com.example.springprojectlbd.dto.SprintDtoSlim;
import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.event.UserStoryCreatedEvent;
import com.example.springprojectlbd.repository.SprintRepository;
import com.example.springprojectlbd.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLDataException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SprintService {
SprintRepository sprintRepository;
UserStoryRepository userStoryRepository;
UserStoryService userStoryService;
@Autowired
    public SprintService(SprintRepository sprintRepository,UserStoryRepository userStoryRepository, UserStoryService userStoryService) {
        this.sprintRepository = sprintRepository;
        this.userStoryRepository=userStoryRepository;
        this.userStoryService = userStoryService;
    }
@Transactional
    public void saveData(int id, String name, Timestamp dataStart, Timestamp dataEnd, String description, Sprint.StatusType status) throws SQLDataException {
    if(id<0||name.isEmpty()||(dataStart.compareTo(dataEnd)>0)){
        throw new SQLDataException();
    }
    else{
    Sprint sprint = new Sprint(id,name,dataStart,dataEnd,description,status);
    sprintRepository.save(sprint);
    }
}

public Set<UserStory> getUserStoryList(long id){
    Optional<Sprint> result=sprintRepository.findById(id);
   return result.map(sprint -> sprint.getUserStories()).orElse(null);
}

public Optional<List<Sprint>>getSprintRealizedBetween(Timestamp begin,Timestamp end){
    return sprintRepository.findBetweenData(begin,end);
}

public Optional<Integer> countValue(Long id){
    return sprintRepository.returnCountOfStoryPoint(id);
}
    public void saveNewUserStory(Long id){
        Optional<Sprint> sprintOptional = sprintRepository.findById(id);
        UserStory userStory= userStoryService.addToUserStory(new UserStory(121,"name","description",30,"To do"));
        sprintOptional.ifPresent(sprint -> {sprint.getUserStories().add(userStory);
        sprintRepository.save(sprint);});

    }

    public void changeDescritptionInSprint(Long id){
        Optional<Sprint> sprintOptional = sprintRepository.findById(id);
        sprintOptional.ifPresent(sprint -> {sprint.setDescription("nowy opis");
        sprintRepository.save(sprint);});

    }

    public void updateStatus(Long id, Sprint.StatusType statusType){
        Optional<Sprint> sprintOptional = sprintRepository.findById(id);
        sprintOptional.ifPresent(sprint -> {sprint.setStatus(statusType);
            sprintRepository.save(sprint);});
    }
    @EventListener
    public void handleAddStoryEvent(UserStoryCreatedEvent event) {
        System.out.println("Dziala");
    }





//////////////Mappers
    public SprintDto mapToSprintDto(Sprint sprint,boolean listOrNot){

    SprintDto sprintDto = new SprintDto(sprint.getId(), sprint.getSprintName(), sprint.getStartTime(),sprint.getEndTime(),sprint.getDescription(),sprint.getStatus());
if(listOrNot) {
    sprintDto.setUserStories(sprint.getUserStories().stream().
            map(userStory -> userStoryService.mapToUserStoryDto(userStory)).
            collect(Collectors.toSet()));
}
        return sprintDto;


        }

    public SprintDtoSlim mapToSprintDtoSlim(Sprint sprint){
    return new SprintDtoSlim(sprint.getSprintName(),sprint.getStartTime(),sprint.getEndTime(),sprint.getStatus());
    }


    }








