package com.example.springprojectlbd.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserStoryDtoSlim {

    private Long id;
    @NotNull
    private String userStoryName;
    private int countOfStoryPoint;
    @NotNull
    private String status;



}
