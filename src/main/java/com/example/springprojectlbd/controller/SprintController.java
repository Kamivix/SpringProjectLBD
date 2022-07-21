package com.example.springprojectlbd.controller;

import com.example.springprojectlbd.dto.SprintDto;
import com.example.springprojectlbd.dto.SprintDtoSlim;
import com.example.springprojectlbd.dto.UserStoryDtoSlim;
import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.event.UserStoryCreatedEvent;
import com.example.springprojectlbd.repository.SprintRepository;
import com.example.springprojectlbd.services.SprintService;
import com.example.springprojectlbd.services.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
public class SprintController {
private  final SprintService sprintService;
    private final SprintRepository sprintRepository;
    private final UserStoryService userStoryService;
    private final ApplicationEventPublisher publisher;
    @Autowired
    public SprintController(SprintService sprintService, SprintRepository sprintRepository, UserStoryService userStoryService, ApplicationEventPublisher applicationEventPublisher) {
        this.sprintService = sprintService;
        this.sprintRepository = sprintRepository;
        this.userStoryService = userStoryService;
        this.publisher=applicationEventPublisher;
    }


@PutMapping("update/{id}")
public void update(@PathVariable Long id){
        sprintService.changeDescritptionInSprint(id);

}
@DeleteMapping("delete/{id}")
public void delete(@PathVariable Long id){
        userStoryService.delete(id);
}







    @GetMapping("sprints/{listOrNot}")
    List<SprintDto> sprintList(@PathVariable boolean listOrNot){
        List<Sprint> sprints= (List<Sprint>) sprintRepository.findAll();
        List<SprintDto> afterMappingList = new ArrayList<>();
for(Sprint s:sprints){
    afterMappingList.add(sprintService.mapToSprintDto(s,listOrNot));

}

       return afterMappingList;


    }

    //Zad3//
    @PostMapping("sprint/{id}")
    String saveNewUserStoryToSprint(@PathVariable Long id){
    sprintService.saveNewUserStory(id);
    publisher.publishEvent(new UserStoryCreatedEvent(id));
    return "ok";

    }

    //Zad4//
    @GetMapping("points/{id}")
    Optional<Integer> points(@PathVariable Long id){
        return sprintService.countValue(id);
    }

    //Zad5//
@GetMapping("userstories/{id}")
    List<UserStoryDtoSlim> checkUserStories(@PathVariable Long id){


    List<UserStoryDtoSlim> userStoryDtoSlims= new ArrayList<>();
   Set<UserStory> list= sprintService.getUserStoryList(id);
   for (UserStory u:list){
       userStoryDtoSlims.add(userStoryService.mapToUserStorySlimDto(u));
   }
return userStoryDtoSlims;
    }
//Zad 6
    @GetMapping("description/{id}")
    Optional<String> checkDescription(@PathVariable Long id){
        return userStoryService.getDescription(id);
    }

    //zad 9

    @PutMapping("/status/{id}")
    public void setNewStatus(@PathVariable Long id, @RequestParam("statusType") Sprint.StatusType statusType){
        sprintService.updateStatus(id,statusType);
    }

    @GetMapping("betweenTime")
    public List<SprintDtoSlim> betweenTime(@RequestParam Timestamp begin, @RequestParam Timestamp end){
       Optional<List<Sprint>> sprintOptional = sprintService.getSprintRealizedBetween(begin,end);
        List<SprintDtoSlim> sprintDtoSlims = new ArrayList<>();
        for(Sprint s:sprintOptional.get()){
            sprintDtoSlims.add(sprintService.mapToSprintDtoSlim(s));
        }
        return sprintDtoSlims;



    }

    @GetMapping("sorted")
    public List<UserStoryDtoSlim> findPage(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
        return userStoryService.getUserStortedByname(page,limit);
    }




}
