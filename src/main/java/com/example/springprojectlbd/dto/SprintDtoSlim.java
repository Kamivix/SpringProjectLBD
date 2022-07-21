package com.example.springprojectlbd.dto;

import com.example.springprojectlbd.entity.Sprint;

import java.sql.Timestamp;

public class SprintDtoSlim {


    private String sprintName;
    private Timestamp startTime;
    private Timestamp endTime;
    private Sprint.StatusType status;

    public SprintDtoSlim(String sprintName, Timestamp startTime, Timestamp endTime, Sprint.StatusType status) {
        this.sprintName = sprintName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Sprint.StatusType getStatus() {
        return status;
    }

    public void setStatus(Sprint.StatusType status) {
        this.status = status;
    }
}
