package com.example.springprojectlbd.mapper;

import com.example.springprojectlbd.dto.SprintDto;
import com.example.springprojectlbd.dto.UserStoryDto;
import com.example.springprojectlbd.entity.Sprint;
import com.example.springprojectlbd.entity.UserStory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface SprintMapper {

    SprintMapper SPRINT_MAPPER = Mappers.getMapper(SprintMapper.class);

    SprintDto mapToSprintDto(Sprint sprint);
    @Mapping(source = "userStories",target = "userStories")
   Set<UserStoryDto> func(Set<UserStory> userStories);
}
