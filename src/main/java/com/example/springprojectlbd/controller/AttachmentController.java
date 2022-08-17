package com.example.springprojectlbd.controller;

import com.example.springprojectlbd.dto.AttachmentDto;
import com.example.springprojectlbd.entity.Attachment;
import com.example.springprojectlbd.services.AttachmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Attachment")
public class AttachmentController {

    AttachmentService attachmentService;

    @PostMapping("/addAttachment")
    public ResponseEntity<Void> addAttachment(@RequestBody Attachment attachment, @RequestParam long id){

        attachmentService.addAttachment(id,attachment);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAttachment")
    public ResponseEntity <Set<AttachmentDto>> getAttachment(@RequestParam long id){
        return ResponseEntity.ok().header("successful", "true").body(attachmentService.getAttachment(id));
    }
}
