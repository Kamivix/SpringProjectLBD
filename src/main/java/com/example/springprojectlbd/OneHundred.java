package com.example.springprojectlbd;

import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.repository.SprintRepository;
import com.example.springprojectlbd.repository.UserStoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Random;
@AllArgsConstructor
@Component
public class OneHundred {
    UserStoryRepository userStoryRepository;
    SprintRepository sprintRepository;


    public void createOneHundredStory(){
        for(int i=5;i<105;++i){
            String name=function();
            String description = function();
            String status="DONE";
            userStoryRepository.save(UserStory.builder()
                    .userStoryName(name)
                    .description(description)
                    .countOfStoryPoint(i)
                    .status(status)
                    .build());
        }
    }

public void saving(){
        Sprint sprint= Sprint.builder()
                .sprintName("SprintName")
                .startTime(new Timestamp(System.currentTimeMillis()))
                .endTime(new Timestamp(System.currentTimeMillis()))
                .description("Description")
                .status(Sprint.StatusType.PENDING)
                .build();
 sprint.setUserStories(new HashSet<>());
  sprintRepository.save(sprint);
   UserStory userStory =  UserStory.builder()
                    .userStoryName("userStoryName")
                    .countOfStoryPoint(75)
                    .description("Description")
                    .status("DONE")
                    .build();
    userStoryRepository.save(userStory);
   sprint.getUserStories().add(userStory);
   sprintRepository.save(sprint);

}
    private   String function() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();




    }

}

