package com.example.springprojectlbd.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER_STORY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserStory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "USERSTORYNAME")
    private String userStoryName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COUNTOFSTORYPOINT")
    private int countOfStoryPoint;

    @Column(name = "STATUS")
    private String status;

    @OneToMany(mappedBy="userStoryLink")
Set<Attachment> attachments= new HashSet<>();

@ManyToMany(mappedBy = "userStories",fetch=FetchType.LAZY)
    Set<Sprint> sprints= new HashSet<>();



}
