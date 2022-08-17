package com.example.springprojectlbd.services;
import com.example.springprojectlbd.dto.UserStoryDtoSlim;
import com.example.springprojectlbd.entity.UserStory;

import java.util.List;


public interface UserStoryService {

    UserStory addToUserStory(UserStory userStory);
    String getDescription(Long id);
    void delete(Long id);

    List<UserStoryDtoSlim> getUserStorySortedByName(int page, int limit);


}
