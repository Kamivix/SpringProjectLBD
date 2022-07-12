package com.example.springprojectlbd.services;


import com.example.springprojectlbd.dto.UserStoryDto;
import com.example.springprojectlbd.dto.UserStoryDtoSlim;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserStoryService {
    UserStoryRepository userStoryRepository;

    @Autowired
    public UserStoryService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }


    public UserStory addToUserStory(UserStory userStory){
        userStoryRepository.save(userStory);
        return userStory;
    }

    public Optional<String> getDescription(Long id){
        return userStoryRepository.findById(id).map(userStory -> userStory.getDescription());
    }

    /////mapper/////
    public UserStoryDto mapToUserStoryDto(UserStory userStory) {
        return new UserStoryDto(userStory.getId(), userStory.getUserStoryName(), userStory.getDescription(), userStory.getCountOfStoryPoint(), userStory.getStatus());

    }

    public UserStoryDtoSlim mapToUserStorySlimDto(UserStory userStory){
        return new UserStoryDtoSlim(userStory.getId(), userStory.getUserStoryName(), userStory.getCountOfStoryPoint(), userStory.getStatus());
    }


}








