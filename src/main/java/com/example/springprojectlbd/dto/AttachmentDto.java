package com.example.springprojectlbd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AttachmentDto {
   final private Long id;
    private byte[] binaryFile;


}
