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
import com.example.springprojectlbd.services.SprintServiceImpl;
import com.example.springprojectlbd.services.UserStoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;


@RestController

public class MainController {
    private  final SprintServiceImpl sprintServiceImpl;
    private final SprintRepository sprintRepository;
    private final UserStoryServiceImpl userStoryServiceImpl;
    private final ApplicationEventPublisher publisher;
    @Autowired
    public MainController(SprintServiceImpl sprintServiceImpl, SprintRepository sprintRepository, UserStoryServiceImpl userStoryServiceImpl, ApplicationEventPublisher applicationEventPublisher) {
        this.sprintServiceImpl = sprintServiceImpl;
        this.sprintRepository = sprintRepository;
        this.userStoryServiceImpl = userStoryServiceImpl;
        this.publisher=applicationEventPublisher;
    }


        @PutMapping("update/{id}")
        public ResponseEntity<Void> update(@PathVariable Long id){
        sprintServiceImpl.changeDescriptionInSprint(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
        @DeleteMapping("delete/{id}")
            public ResponseEntity<Void> delete(@PathVariable Long id){
        userStoryServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

    @GetMapping("sprints/{listOrNot}")
    ResponseEntity <List<SprintDto>> sprintList(@PathVariable boolean listOrNot){
        List<Sprint> sprints= (List<Sprint>) sprintRepository.findAll();
        List<SprintDto> afterMappingList = new ArrayList<>();
for(Sprint s:sprints){
    afterMappingList.add(sprintServiceImpl.mapToSprintDto(s,listOrNot));

}

       return ResponseEntity.ok().header("successful", "true").body(afterMappingList);


    }

    @PostMapping("sprint/{id}")
   ResponseEntity<String> saveNewUserStoryToSprint(@PathVariable Long id){
    sprintServiceImpl.saveNewUserStory(id);
    publisher.publishEvent(new UserStoryCreatedEvent(id));
    return ResponseEntity.ok().header("successful", "true").body("ok");

    }

    @GetMapping("points/{id}")
    ResponseEntity<Optional<Integer>> points(@PathVariable Long id){
        return ResponseEntity.ok().header("successful", "true").body(sprintServiceImpl.countValue(id));
    }

    @GetMapping("userstories/{id}")
     ResponseEntity<List<UserStoryDtoSlim>> checkUserStories(@PathVariable Long id){


    List<UserStoryDtoSlim> userStoryDtoSlims= new ArrayList<>();
   Set<UserStory> list= sprintServiceImpl.getUserStoryList(id);
   for (UserStory u:list){
       userStoryDtoSlims.add(userStoryServiceImpl.mapToUserStorySlimDto(u));
   }
return ResponseEntity.ok().header("successful", "true").body(userStoryDtoSlims);
    }

    @GetMapping("description/{id}")
    ResponseEntity<Optional<String>> checkDescription(@PathVariable Long id){
        return ResponseEntity.ok().header("successful", "true").body(userStoryServiceImpl.getDescription(id));
    }



    @PutMapping("/status/{id}")
    public ResponseEntity<Void> setNewStatus(@PathVariable Long id, @RequestParam("statusType") Sprint.StatusType statusType){
        sprintServiceImpl.updateStatus(id,statusType);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("betweenTime")
    public ResponseEntity<List<SprintDtoSlim>> betweenTime(@RequestParam Timestamp begin, @RequestParam Timestamp end){
       Optional<List<Sprint>> sprintOptional = sprintServiceImpl.getSprintRealizedBetween(begin,end);
        List<SprintDtoSlim> sprintDtoSlims = new ArrayList<>();
        for(Sprint s:sprintOptional.get()){
            sprintDtoSlims.add(sprintServiceImpl.mapToSprintDtoSlim(s));
        }
        return ResponseEntity.ok().header("successful", "true").body(sprintDtoSlims);
    }

    @GetMapping("sorted")
    public ResponseEntity<List<UserStoryDtoSlim>> findPage(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
        return ResponseEntity.ok().header("successful", "true").body(userStoryServiceImpl.getUserSortedByName(page,limit));
    }

    @GetMapping("/Test")
    public ResponseEntity<String> getLoggedUser() {
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().header("successful", "true").body(auth.getName() + " " + auth.getAuthorities());
    }


    @PostMapping("/addAttachment")
    public ResponseEntity<Void> addAttachmetn(@RequestBody Attachment attachment, @RequestParam long id){
        userStoryServiceImpl.addAttachment(id,attachment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAttachment")
    public ResponseEntity <Set<AttachmentDto>> getAttachment(@RequestParam long id){
        Set<Attachment> set = userStoryServiceImpl.getAttachment(id).get();
        Set<AttachmentDto> attachmentDtos= new HashSet<>();
            for(Attachment a:set){
                attachmentDtos.add(userStoryServiceImpl.mapToAttachmentDto(a));
      }

      return ResponseEntity.ok().header("successful", "true").body(attachmentDtos);
    }




}
