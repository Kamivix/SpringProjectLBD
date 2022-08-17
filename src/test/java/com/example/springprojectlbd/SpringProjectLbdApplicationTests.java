package com.example.springprojectlbd;

import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.repository.UserStoryRepository;
import com.example.springprojectlbd.services.SprintServiceImpl;
import com.example.springprojectlbd.services.UserStoryServiceImpl;
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
    SprintServiceImpl sprintServiceImpl;
@Autowired
UserStoryServiceImpl userStoryServiceImpl;
@Autowired
UserStoryRepository userStoryRepository;
@Autowired
OneHundred oneHundred;

  @Test
    public void work() throws SQLDataException {

       sprintServiceImpl.saveData("ja",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),"Pending", Sprint.StatusType.valueOf("Pending"));
  }

@Test
  public void test2(){
      System.out.println(sprintServiceImpl.getSprintRealizedBetween(Timestamp.valueOf("2022-07-08 13:29:17.276527"),Timestamp.valueOf("2022-12-31 00:00:00.000000")));  }

@Test
    public void  test3(){
    System.out.println(sprintServiceImpl.countValue(3L));
}

@Test
    public void nextTest(){

    Page<UserStory> userStories =userStoryRepository.findAll(PageRequest.of(0,10));
    assert (userStories.getSize()==10);
}

@Test
    public void doesItWork(){
      oneHundred.saving();
}



}