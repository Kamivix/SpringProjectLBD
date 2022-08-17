package com.example.springprojectlbd.services;

import com.example.springprojectlbd.dto.UserStoryDtoSlim;
import com.example.springprojectlbd.entity.Attachment;
import com.example.springprojectlbd.entity.UserStory;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserStoryService {

    UserStory addToUserStory(UserStory userStory);
    Optional<String> getDescription(Long id);
    void delete(Long id);

    List<UserStoryDtoSlim> getUserSortedByName(int page, int limit);

    void addAttachment(Long id, Attachment attachment);

    Optional<Set<Attachment>> getAttachment(Long id);
}
