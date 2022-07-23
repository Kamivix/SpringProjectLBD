package com.example.springprojectlbd.entity;

import javax.persistence.*;

@Entity
@Table(name = "ATTACHMENT")
public class Attachment {
    @Id
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USERSTORY_ID")
    private UserStory userStoryLink;

    @Column(name = "BINARYFILE")
    private byte[] binaryFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserStory getUserStoryLink() {
        return userStoryLink;
    }

    public void setUserStoryLink(UserStory userStoryLink) {
        this.userStoryLink = userStoryLink;
    }

    public byte[] getBinaryFile() {
        return binaryFile;
    }

    public void setBinaryFile(byte[] binaryFile) {
        this.binaryFile = binaryFile;
    }
}
