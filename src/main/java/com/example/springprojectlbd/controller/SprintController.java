package com.example.springprojectlbd.controller;

import com.example.springprojectlbd.dto.*;
import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.event.UserStoryCreatedEvent;
import com.example.springprojectlbd.services.SprintService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/sprint")
public class SprintController {
    private  final SprintService sprintService;
    private final ApplicationEventPublisher publisher;


        @PutMapping("/update/{id}")
            public ResponseEntity<Void> update(@PathVariable Long id,@RequestParam("description") String description){
            sprintService.changeDescriptionInSprint(id,description);
            return ResponseEntity.ok().build();
}


         @GetMapping("/sprints/{listOrNot}")
            ResponseEntity <List<SprintDto>> sprintList(@PathVariable boolean listOrNot){
            return ResponseEntity.ok().header("successful", "true").body(sprintService.getSprints(listOrNot));


    }

        @PostMapping("/{id}")
            ResponseEntity<String> saveNewUserStoryToSprint(@PathVariable Long id, @Valid  @RequestBody  UserStoryDto userStoryDto){
            sprintService.saveNewUserStory(id, userStoryDto);
            publisher.publishEvent(new UserStoryCreatedEvent(id));
            return ResponseEntity.ok().header("successful", "true").body("ok");

    }

         @GetMapping("/points/{id}")
            ResponseEntity<Integer> points(@PathVariable Long id){
            return ResponseEntity.ok().header("successful", "true").body(sprintService.countValue(id));
    }

        @GetMapping("/userStories/{id}")
            ResponseEntity<Set<UserStoryDto>> checkUserStories(@PathVariable Long id){
            return ResponseEntity.ok().header("successful", "true").body(sprintService.getUserStoryList(id));
    }


    @PutMapping("/status/{id}")
    public ResponseEntity<Void> setNewStatus(@PathVariable Long id, @RequestParam("statusType") Sprint.StatusType statusType){

        sprintService.updateStatus(id,statusType);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/betweenTime")
    public ResponseEntity<List<SprintDtoSlim>> betweenTime(@RequestParam("begin") Timestamp begin, @RequestParam("end") Timestamp end){

        return ResponseEntity.ok().header("successful", "true").body(sprintService.getSprintRealizedBetween(begin,end));
    }

    @GetMapping("/test")
    public ResponseEntity<String> getLoggedUser() {
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().header("successful", "true").body(auth.getName() + " " + auth.getAuthorities());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> setNewSprint(@Valid @RequestBody SprintDto sprintDto){
            sprintService.saveNewSprint(sprintDto);

            return ResponseEntity.ok().build();
    }








}
