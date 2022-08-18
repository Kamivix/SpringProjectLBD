package com.example.springprojectlbd.controller;

import com.example.springprojectlbd.dto.AttachmentDto;
import com.example.springprojectlbd.entity.Attachment;
import com.example.springprojectlbd.services.AttachmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Attachment")
public class AttachmentController {

    AttachmentService attachmentService;

    @PostMapping("/addAttachment")
    public ResponseEntity<Void> addAttachment(@RequestParam("file") MultipartFile attachment, @RequestParam("userStoryId") long id){
AttachmentDto attachmentDto= new AttachmentDto();
try{
    attachmentDto.setBinaryFile(attachment.getBytes());
} catch (IOException e) {
    throw new RuntimeException(e);
}
        attachmentService.addAttachment(id,attachmentDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAttachment")
    public ResponseEntity <String> getAttachment(@RequestParam("id") long id){
        return ResponseEntity.ok().header("successful", "true").body(attachmentService.getAttachment(id));
    }
}
