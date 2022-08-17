package com.example.springprojectlbd.mapper;


import com.example.springprojectlbd.dto.UserStoryDto;
import com.example.springprojectlbd.dto.UserStoryDtoSlim;
import com.example.springprojectlbd.entity.UserStory;
import org.mapstruct.*;


import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface UserStoryMapper {
    @Named("mapEntityToDtoUserStory")
    UserStoryDto mapEntityToDtoUserStory(UserStory userStory);
    @Named("mapDtoToEntityUserStory")
    UserStory mapDtoToEntityUserStory(UserStoryDto userStoryDto);
    @Named("mapEntityToDtoListUserStory")
    @IterableMapping(qualifiedByName = "mapEntityToDtoUserStory")
    Set<UserStoryDto> mapEntityToDtoSetUserStory(Set<UserStory> userStories);
    @Named("mapEntityToDtoSlimUserStory")
    UserStoryDtoSlim mapEntityToDtoSlimUserStory(UserStory userStory);
    @Named("mapEntityToDtoSlimListUserStory")
    @IterableMapping(qualifiedByName = "mapEntityToDtoSlimUserStory")
    List<UserStoryDtoSlim> mapEntityToDtoSlimListUserStory(List<UserStory> userStories);

    @Named("mapEntityToDto")
    UserStory mapEntityToDto(UserStoryDto source);



}
