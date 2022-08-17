package com.example.springprojectlbd.dto;

import com.example.springprojectlbd.entity.Sprint;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor

public class SprintDto {

    private Long id;
    @NotNull
    private String sprintName;
    private Timestamp startTime;
    private Timestamp endTime;
    private String description;
    @NotNull
    private Sprint.StatusType status;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<UserStoryDto> userStories;




}


