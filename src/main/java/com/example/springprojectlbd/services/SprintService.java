package com.example.springprojectlbd.services;

import com.example.springprojectlbd.dto.SprintDto;
import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.repository.SprintRepository;
import com.example.springprojectlbd.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void saveData(int id, String name, Timestamp dataStart,Timestamp dataEnd, String description, String status) throws SQLDataException {
    if(id<0||name.isEmpty()||(dataStart.compareTo(dataEnd)>0)||status.isEmpty()){
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

public Optional<Integer> countValue(){
    return sprintRepository.returnCountOfStoryPoint();
}


//////////////Mappers
    public SprintDto mapToSprintDto(Sprint sprint){

    SprintDto sprintDto = new SprintDto(sprint.getId(), sprint.getSprintName(), sprint.getStartTime(),sprint.getEndTime(),sprint.getDescription(),sprint.getStatus());
sprintDto.setUserStories(sprint.getUserStories().stream().map(userStory -> userStoryService.mapToUserStoryDto(userStory)).collect(Collectors.toSet()));
        System.out.println(sprint.getUserStories());
        return sprintDto;

    }
}
