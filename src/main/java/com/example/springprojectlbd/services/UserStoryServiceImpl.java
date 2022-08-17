package com.example.springprojectlbd.services;


import com.example.springprojectlbd.dto.UserStoryDtoSlim;
import com.example.springprojectlbd.entity.Attachment;
import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.mapper.AttachmentMapper;
import com.example.springprojectlbd.mapper.UserStoryMapper;
import com.example.springprojectlbd.repository.AttachmentRepository;
import com.example.springprojectlbd.repository.UserStoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Iterator;
import java.util.List;



@Service
@AllArgsConstructor
public class UserStoryServiceImpl implements UserStoryService {
    UserStoryRepository userStoryRepository;
    AttachmentRepository attachmentRepository;

    UserStoryMapper userStoryMapper;
    AttachmentMapper attachmentMapper;


    @Override
    public UserStory addToUserStory(UserStory userStory){
        userStoryRepository.save(userStory);
        return userStory;
    }
    @Override
    public String getDescription(Long id){
        UserStory userStory= userStoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Entity with "+ id +" not found"));
        return userStory.getDescription();
    }
    @Override
    public void delete(Long id){
       UserStory userStory= userStoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Entity with "+ id +" not found"));

       for(Sprint s:userStory.getSprints()){
          s.getUserStories().remove(userStory);
       }
       Iterator<Attachment> it = userStory.getAttachments().iterator();
        attachmentRepository.deleteAll(userStory.getAttachments());
        while (it.hasNext()){
            Attachment a = it.next();
            it.remove();
        }
       userStoryRepository.delete(userStory);

    }
    @Override
    public List<UserStoryDtoSlim> getUserStorySortedByName(int page, int limit){
        Page<UserStory> pa= userStoryRepository.findAll(PageRequest.of(page, limit, Sort.by("userStoryName").ascending()));
        List<UserStory> list = pa.toList();
        return userStoryMapper.mapEntityToDtoSlimListUserStory(list);
    }


}








