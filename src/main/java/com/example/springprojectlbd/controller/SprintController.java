package com.example.springprojectlbd.controller;

import com.example.springprojectlbd.dto.AttachmentDto;
import com.example.springprojectlbd.dto.SprintDto;
import com.example.springprojectlbd.dto.SprintDtoSlim;
import com.example.springprojectlbd.dto.UserStoryDtoSlim;
import com.example.springprojectlbd.entity.Attachment;
import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.event.UserStoryCreatedEvent;
import com.example.springprojectlbd.repository.SprintRepository;
import com.example.springprojectlbd.services.SprintService;
import com.example.springprojectlbd.services.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;


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
public ResponseEntity update(@PathVariable Long id){
        sprintService.changeDescritptionInSprint(id);
return ResponseEntity.ok().header("successful", "true").body("Udalo sie");
}
@DeleteMapping("delete/{id}")
public ResponseEntity delete(@PathVariable Long id){
        userStoryService.delete(id);
        return ResponseEntity.ok().header("successful", "true").body("Udalo sie");
}







    @GetMapping("sprints/{listOrNot}")
    ResponseEntity <List<SprintDto>> sprintList(@PathVariable boolean listOrNot){
        List<Sprint> sprints= (List<Sprint>) sprintRepository.findAll();
        List<SprintDto> afterMappingList = new ArrayList<>();
for(Sprint s:sprints){
    afterMappingList.add(sprintService.mapToSprintDto(s,listOrNot));

}

       return ResponseEntity.ok().header("successful", "true").body(afterMappingList);


    }

    //Zad3//
    @PostMapping("sprint/{id}")
   ResponseEntity<String> saveNewUserStoryToSprint(@PathVariable Long id){
    sprintService.saveNewUserStory(id);
    publisher.publishEvent(new UserStoryCreatedEvent(id));
    return ResponseEntity.ok().header("successful", "true").body("ok");

    }

    //Zad4//
    @GetMapping("points/{id}")
    ResponseEntity<Optional<Integer>> points(@PathVariable Long id){
        return ResponseEntity.ok().header("successful", "true").body(sprintService.countValue(id));
    }

    //Zad5//
@GetMapping("userstories/{id}")
     ResponseEntity<List<UserStoryDtoSlim>> checkUserStories(@PathVariable Long id){


    List<UserStoryDtoSlim> userStoryDtoSlims= new ArrayList<>();
   Set<UserStory> list= sprintService.getUserStoryList(id);
   for (UserStory u:list){
       userStoryDtoSlims.add(userStoryService.mapToUserStorySlimDto(u));
   }
return ResponseEntity.ok().header("successful", "true").body(userStoryDtoSlims);
    }
//Zad 6
    @GetMapping("description/{id}")
    ResponseEntity<Optional<String>> checkDescription(@PathVariable Long id){
        return ResponseEntity.ok().header("successful", "true").body(userStoryService.getDescription(id));
    }

    //zad 9

    @PutMapping("/status/{id}")
    public ResponseEntity setNewStatus(@PathVariable Long id, @RequestParam("statusType") Sprint.StatusType statusType){
        sprintService.updateStatus(id,statusType);
        return ResponseEntity.ok().header("successful", "true").body("Udalo sie");
    }

    @GetMapping("betweenTime")
    public ResponseEntity<List<SprintDtoSlim>> betweenTime(@RequestParam Timestamp begin, @RequestParam Timestamp end){
       Optional<List<Sprint>> sprintOptional = sprintService.getSprintRealizedBetween(begin,end);
        List<SprintDtoSlim> sprintDtoSlims = new ArrayList<>();
        for(Sprint s:sprintOptional.get()){
            sprintDtoSlims.add(sprintService.mapToSprintDtoSlim(s));
        }
        return ResponseEntity.ok().header("successful", "true").body(sprintDtoSlims);



    }

    @GetMapping("sorted")
    public ResponseEntity<List<UserStoryDtoSlim>> findPage(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
        return ResponseEntity.ok().header("successful", "true").body(userStoryService.getUserStortedByname(page,limit));
    }

    @GetMapping("/Test")
    public ResponseEntity getLoggedUser() {
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().header("successful", "true").body(auth.getName() + " " + auth.getAuthorities());
    }


    @PostMapping("/addAttachment")
    public ResponseEntity addAttachmetn(@RequestBody Attachment attachment, @RequestParam long id){
        userStoryService.addAttachment(id,attachment);
        return ResponseEntity.ok().header("successful", "true").body("Dodano zalacznik");
    }

    @GetMapping("/getAttachment")
public ResponseEntity <Set<AttachmentDto>> getAttachment(@RequestParam long id){
        Set<Attachment> set = userStoryService.getAttachment(id).get();
        Set<AttachmentDto> attachmentDtos= new HashSet<>();
      for(Attachment a:set){
          attachmentDtos.add(userStoryService.mapToAttachmentDto(a));
      }

      return ResponseEntity.ok().header("successful", "true").body(attachmentDtos);
    }




}
