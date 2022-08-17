package com.example.springprojectlbd.services;


import com.example.springprojectlbd.dto.AttachmentDto;
import com.example.springprojectlbd.dto.UserStoryDto;
import com.example.springprojectlbd.dto.UserStoryDtoSlim;
import com.example.springprojectlbd.entity.Attachment;
import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.repository.AttachmentRepository;
import com.example.springprojectlbd.repository.UserStoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserStoryServiceImpl implements UserStoryService {
    UserStoryRepository userStoryRepository;
    AttachmentRepository attachmentRepository;


    @Override
    public UserStory addToUserStory(UserStory userStory){
        userStoryRepository.save(userStory);
        return userStory;
    }
    @Override
    public Optional<String> getDescription(Long id){
        return userStoryRepository.findById(id).map(UserStory::getDescription);
    }
    @Override
    public void delete(Long id){
       Optional<UserStory> optionalUserStory= userStoryRepository.findById(id);
       for(Sprint s:optionalUserStory.get().getSprints()){
          s.getUserStories().remove(optionalUserStory.get());
       }
       Iterator<Attachment> it = optionalUserStory.get().getAttachments().iterator();
        attachmentRepository.deleteAll(optionalUserStory.get().getAttachments());
        while (it.hasNext()){
            Attachment a = it.next();
            it.remove();
        }
       userStoryRepository.delete(optionalUserStory.get());

    }
    @Override
    public List<UserStoryDtoSlim> getUserSortedByName(int page, int limit){
        Page<UserStory> pa= userStoryRepository.findAll(PageRequest.of(page, limit, Sort.by("userStoryName").ascending()));
        return pa.stream().map(this::mapToUserStorySlimDto).collect(Collectors.toList());
    }
    @Override
    public void addAttachment(Long id, Attachment attachment){
        Optional<UserStory> userStory= userStoryRepository.findById(id);
        attachmentRepository.save(attachment);
        userStory.ifPresent(userStory1 -> {userStory1.getAttachments().add(attachment);
        userStoryRepository.save(userStory1);});
    }
@Override
    public Optional<Set<Attachment>> getAttachment(Long id){
    Optional<UserStory> optionalUserStory = userStoryRepository.findById(id);
     return optionalUserStory.map(UserStory::getAttachments);
    }



    /////mapper/////
    public UserStoryDto mapToUserStoryDto(UserStory userStory) {
        return new UserStoryDto(userStory.getId(), userStory.getUserStoryName(), userStory.getDescription(), userStory.getCountOfStoryPoint(), userStory.getStatus());

    }

    public UserStoryDtoSlim mapToUserStorySlimDto(UserStory userStory){
        return new UserStoryDtoSlim(userStory.getId(), userStory.getUserStoryName(), userStory.getCountOfStoryPoint(), userStory.getStatus());
    }

    public AttachmentDto mapToAttachmentDto(Attachment attachment){
    return  new AttachmentDto(attachment.getId(), attachment.getBinaryFile());
    }






}








