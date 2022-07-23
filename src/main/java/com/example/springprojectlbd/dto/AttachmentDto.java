package com.example.springprojectlbd.dto;

public class AttachmentDto {
    private Long id;
    private byte[] binaryFile;

    public AttachmentDto(Long id, byte[] binaryFile) {
        this.id=id;
        this.binaryFile=binaryFile;
    }

    public byte[] getBinaryFile() {
        return binaryFile;
    }

    public void setBinaryFile(byte[] binaryFile) {
        this.binaryFile = binaryFile;
    }
}
