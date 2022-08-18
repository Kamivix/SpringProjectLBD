package com.example.springprojectlbd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class AttachmentDto {
    private Long id;
    private byte[] binaryFile;


}
