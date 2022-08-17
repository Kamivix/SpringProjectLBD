package com.example.springprojectlbd.dto;

import com.example.springprojectlbd.entity.Sprint;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Setter
@Getter
@AllArgsConstructor
public class SprintDtoSlim {

    @NotNull
    private String sprintName;
    private Timestamp startTime;
    private Timestamp endTime;
    @NotNull
    private Sprint.StatusType status;




}
