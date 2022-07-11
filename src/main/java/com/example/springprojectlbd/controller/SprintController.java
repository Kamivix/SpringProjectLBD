package com.example.springprojectlbd.controller;

import com.example.springprojectlbd.dto.SprintDto;
import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.repository.SprintRepository;
import com.example.springprojectlbd.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SprintController {
private  final SprintService sprintService;
    private final SprintRepository sprintRepository;
    @Autowired
    public SprintController(SprintService sprintService, SprintRepository sprintRepository) {
        this.sprintService = sprintService;
        this.sprintRepository = sprintRepository;
    }







    @GetMapping(value = "Sprint")
    List<SprintDto> sprintList(){
        List<Sprint> sprints= (List<Sprint>) sprintRepository.findAll();
        List<SprintDto> afterMappingList = new ArrayList<>();
for(Sprint s:sprints){
    afterMappingList.add(sprintService.mapToSprintDto(s));

}

       return afterMappingList;


    }
}
