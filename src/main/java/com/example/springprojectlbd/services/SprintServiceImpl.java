package com.example.springprojectlbd.services;

import com.example.springprojectlbd.dto.SprintDto;
import com.example.springprojectlbd.dto.SprintDtoSlim;
import com.example.springprojectlbd.dto.UserStoryDto;
import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.event.UserStoryCreatedEvent;
import com.example.springprojectlbd.mapper.SprintMapper;
import com.example.springprojectlbd.mapper.UserStoryMapper;
import com.example.springprojectlbd.repository.SprintRepository;
import com.example.springprojectlbd.repository.UserStoryRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.sql.SQLDataException;
import java.sql.Timestamp;
import java.util.*;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SprintServiceImpl implements SprintService {
SprintRepository sprintRepository;
UserStoryRepository userStoryRepository;
UserStoryService userStoryService;
SprintMapper sprintMapper;
UserStoryMapper userStoryMapper;

private static final Logger logger = LoggerFactory.getLogger(UserStoryCreatedEvent.class);

    @Transactional
    public void saveData(String name, Timestamp dataStart, Timestamp dataEnd, String description, Sprint.StatusType status) throws SQLDataException {
    if(name.isEmpty()||(dataStart.compareTo(dataEnd)>0)){
        throw new SQLDataException();
    }
    else{
    Sprint sprint = Sprint.builder()
            .sprintName(name)
            .startTime(dataStart)
            .endTime(dataEnd)
            .status(status)
            .description(description)
            .build();
    sprintRepository.save(sprint);
    }
}
@Override
public List<SprintDto> getSprints(Boolean listOrNot){
    List<Sprint> sprints = (List<Sprint>) sprintRepository.findAll();
   return sprints.stream().map(sprint -> {
       SprintDto sprintDto = sprintMapper.mapEntityToDtoSprint(sprint);
       if(!listOrNot)
           sprintDto.setUserStories(new HashSet<>());
       return sprintDto;
   }).collect(Collectors.toList());

}

    @Override
    public Set<UserStoryDto> getUserStoryList(long id){
    Sprint result=sprintRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Entity with "+ id +" not found"));

   return userStoryMapper.mapEntityToDtoSetUserStory(result.getUserStories());
}
    @Override
    public List<SprintDtoSlim>getSprintRealizedBetween(Timestamp begin,Timestamp end){
        List<Sprint> sprints= sprintRepository.findBetweenData(begin,end).orElseThrow(()->new EntityNotFoundException("Entity between "+begin+" and "+ end  +" not found"));

    return sprintMapper.mapEntityListToDtoSlimListSprint(sprints);
}
    @Override
    public Integer countValue(Long id){
    return sprintRepository.returnCountOfStoryPoint(id).orElseThrow(()->new EntityNotFoundException(("Entity with "+ id +" not found")));
}
    @Override
    public void saveNewUserStory(Long id, UserStoryDto userStoryDto){
        Sprint sprint = sprintRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Entity with "+ id +" not found"));
        UserStory userStory= userStoryService.addToUserStory(userStoryMapper.mapDtoToEntityUserStory(userStoryDto));
        sprint.getUserStories().add(userStory);
        sprintRepository.save(sprint);


    }
    @Override
    public void changeDescriptionInSprint(Long id,String description){
        Sprint sprint = sprintRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Entity with "+ id +" not found"));
        sprint.setDescription(description);
        sprintRepository.save(sprint);

    }
    @Override
    public void updateStatus(Long id, Sprint.StatusType statusType){
        Optional<Sprint> sprintOptional = sprintRepository.findById(id);
        sprintOptional.ifPresent(sprint -> {sprint.setStatus(statusType);
            sprintRepository.save(sprint);});
    }
    @EventListener
    @Override
    public void handleAddStoryEvent(UserStoryCreatedEvent event) {
        logger.info("Work id "+ event.getUserStoryId());
    }


    }








