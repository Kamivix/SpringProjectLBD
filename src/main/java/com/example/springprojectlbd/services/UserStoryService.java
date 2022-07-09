package com.example.springprojectlbd.services;


import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserStoryService {
UserStoryRepository userStoryRepository;

@Autowired
    public UserStoryService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

public void test(){

}

    }








