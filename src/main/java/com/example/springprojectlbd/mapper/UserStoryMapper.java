package com.example.springprojectlbd.mapper;


import com.example.springprojectlbd.dto.UserStoryDto;
import com.example.springprojectlbd.entity.UserStory;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(uses = SprintMapper.class)
public interface UserStoryMapper {
UserStoryMapper userStoryMapper= Mappers.getMapper(UserStoryMapper.class);
    UserStoryDto mapToUserStoryDto(UserStory userStory);
    @InheritInverseConfiguration
    UserStory opposite (UserStoryDto userStoryDto);


}
