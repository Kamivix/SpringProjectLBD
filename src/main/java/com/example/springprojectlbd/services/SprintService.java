package com.example.springprojectlbd.services;

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

@Service
public class SprintService {
SprintRepository sprintRepository;
UserStoryRepository userStoryRepository;
@Autowired
    public SprintService(SprintRepository sprintRepository,UserStoryRepository userStoryRepository) {
        this.sprintRepository = sprintRepository;
        this.userStoryRepository=userStoryRepository;
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



}
