package com.example.springprojectlbd.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserStoryDto
{

    private Long id;
    @NotNull   private String userStoryName;
    private String description;
    private int countOfStoryPoint;
    @NotNull private String status;



}
