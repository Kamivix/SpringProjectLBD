package com.example.springprojectlbd.services;

import com.example.springprojectlbd.dto.AttachmentDto;
import com.example.springprojectlbd.entity.Attachment;
import com.example.springprojectlbd.entity.UserStory;
import com.example.springprojectlbd.mapper.AttachmentMapper;
import com.example.springprojectlbd.repository.AttachmentRepository;
import com.example.springprojectlbd.repository.UserStoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Set;
@Service
@AllArgsConstructor

public class AttachmentServiceImpl implements AttachmentService {

    UserStoryRepository userStoryRepository;
    AttachmentRepository attachmentRepository;
    AttachmentMapper attachmentMapper;

    @Override
    public void addAttachment(Long id, Attachment attachment){
        UserStory userStory= userStoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Entity with "+ id +" not found"));
        attachment.setUserStoryLink(userStory);
        attachmentRepository.save(attachment);

    }
    @Override
    public Set<AttachmentDto> getAttachment(Long id){
        UserStory userStory = userStoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Entity with "+ id +" not found"));
        return attachmentMapper.mapToDtoAttachmentList(userStory.getAttachments());
    }
}
