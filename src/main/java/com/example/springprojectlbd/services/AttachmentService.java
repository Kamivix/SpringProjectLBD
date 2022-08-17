package com.example.springprojectlbd.services;

import com.example.springprojectlbd.dto.AttachmentDto;
import com.example.springprojectlbd.entity.Attachment;

import java.util.Set;

public interface AttachmentService {

    void addAttachment(Long id, Attachment attachment);

    Set<AttachmentDto> getAttachment(Long id);
}
