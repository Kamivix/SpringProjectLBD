package com.example.springprojectlbd.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ATTACHMENT")
@Getter
@Setter
public class Attachment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USERSTORY_ID")
    private UserStory userStoryLink;

    @Column(name = "BINARYFILE")
    private byte[] binaryFile;


}
