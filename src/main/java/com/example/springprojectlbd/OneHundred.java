package com.example.springprojectlbd;

import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.repository.SprintRepository;
import com.example.springprojectlbd.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Random;
@Component
public class OneHundred {
    UserStoryRepository userStoryRepository;
    SprintRepository sprintRepository;

    @Autowired
    public OneHundred(UserStoryRepository userStoryRepository, SprintRepository sprintRepository) {
        this.userStoryRepository = userStoryRepository;
        this.sprintRepository = sprintRepository;
    }




    public void createOneHunderStory(){
        for(int i=5;i<105;++i){
            String name=function();
            long Id=i;
            String description = function();
            int count=i;
            String status="DONE";
            userStoryRepository.save(new UserStory(Id,name,description,count,status));
        }
    }

public void saving(){
        Sprint sprint= new Sprint(3,"ja",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),"Pending",Sprint.StatusType.PENDING);
 sprint.setUserStories(new HashSet<>());
  sprintRepository.save(sprint);
   UserStory userStory = new UserStory(120,"Kamil","Kamil",75,"DONE");
    userStoryRepository.save(userStory);
   sprint.getUserStories().add(userStory);
   sprintRepository.save(sprint);



}
    public  String function() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;




    }

}

