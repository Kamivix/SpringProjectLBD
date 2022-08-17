package com.example.springprojectlbd.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "SPRINT")
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Sprint {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private long id;
    @Column(name="SPRINTNAME", nullable=false)
private String sprintName;
    @Column(name="STARTTIME",nullable = false)
private Timestamp startTime;
    @Column(name="ENDTIME",nullable = false)
private Timestamp endTime;
    @Column(name="DESCRIPTION")
private String description;

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", nullable=false)
    private StatusType status;



    @ManyToMany(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
    @JoinTable(
            name ="SPRINT_USER_STORY",
            joinColumns = @JoinColumn(name="SPRINT_ID"),
            inverseJoinColumns = @JoinColumn(name = "USERSTORY_ID")
    )

private Set<UserStory> userStories ;


    public enum StatusType {
        PENDING, IN_PROGRESS, FINISHED, CANCELED
    }
}
