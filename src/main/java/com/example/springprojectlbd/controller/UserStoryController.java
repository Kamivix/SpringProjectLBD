package com.example.springprojectlbd.controller;

import com.example.springprojectlbd.dto.UserStoryDtoSlim;
import com.example.springprojectlbd.services.UserStoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/userStory")
public class UserStoryController {

UserStoryService userStoryService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userStoryService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/description/{id}")
    ResponseEntity<String>checkDescription(@PathVariable Long id){
        return ResponseEntity.ok().header("successful", "true").body(userStoryService.getDescription(id));
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<UserStoryDtoSlim>> findPage(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit){
        return ResponseEntity.ok().header("successful", "true").body(userStoryService.getUserStorySortedByName(page,limit));
    }
}
