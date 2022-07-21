package com.example.springprojectlbd.services;


import com.example.springprojectlbd.dto.UserStoryDto;
import com.example.springprojectlbd.dto.UserStoryDtoSlim;
import com.example.springprojectlbd.entity.BinaryFile;
import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void delete(Long id){
       Optional<UserStory> optionalUserStory= userStoryRepository.findById(id);
       for(Sprint s:optionalUserStory.get().getSprints()){
           Iterator<UserStory> it = s.getUserStories().iterator();
          s.getUserStories().remove(optionalUserStory.get());
       }
       userStoryRepository.delete(optionalUserStory.get());

    }

    public List<UserStoryDtoSlim> getUserStortedByname(int page, int limit){
        Page<UserStory> pa= userStoryRepository.findAll(PageRequest.of(page, limit, Sort.by("userStoryName").ascending()));
        return pa.stream().map(userStory -> mapToUserStorySlimDto(userStory)).collect(Collectors.toList());
    }

    /////mapper/////
    public UserStoryDto mapToUserStoryDto(UserStory userStory) {
        return new UserStoryDto(userStory.getId(), userStory.getUserStoryName(), userStory.getDescription(), userStory.getCountOfStoryPoint(), userStory.getStatus());

    }

    public UserStoryDtoSlim mapToUserStorySlimDto(UserStory userStory){
        return new UserStoryDtoSlim(userStory.getId(), userStory.getUserStoryName(), userStory.getCountOfStoryPoint(), userStory.getStatus());
    }






}








