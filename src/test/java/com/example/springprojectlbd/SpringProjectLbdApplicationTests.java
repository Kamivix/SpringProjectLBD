package com.example.springprojectlbd;

import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.repository.UserStoryRepository;
import com.example.springprojectlbd.services.SprintService;
import com.example.springprojectlbd.services.UserStoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.sql.SQLDataException;
import java.sql.Timestamp;

@SpringBootTest
class SpringProjectLbdApplicationTests {
    @Autowired
    SprintService sprintService;
@Autowired
    UserStoryService userStoryService;
@Autowired
UserStoryRepository userStoryRepository;

  @Test
    public void work() throws SQLDataException {

      sprintService.saveData(5,"ja",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),"Pending","Pending");
  }

@Test
  public void test2(){
      System.out.println(sprintService.getSprintRealizedBetween(Timestamp.valueOf("2022-07-08 13:29:17.276527"),Timestamp.valueOf("2022-12-31 00:00:00.000000")));  }

@Test
    public void  test3(){
    System.out.println(sprintService.countValue());
}

@Test
    public void nextTest(){

    Page<UserStory> userStories =userStoryRepository.findAll(PageRequest.of(0,10));
    assert (userStories.getSize()==10);
}


}