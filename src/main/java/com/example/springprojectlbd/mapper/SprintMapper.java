package com.example.springprojectlbd.mapper;

import com.example.springprojectlbd.dto.SprintDto;
import com.example.springprojectlbd.dto.SprintDtoSlim;
import com.example.springprojectlbd.entity.Sprint;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SprintMapper {

    @Named("mapEntityToDtoSprint")
    SprintDto mapEntityToDtoSprint(Sprint sprint);
    @Named("mapDtoToEntitySprint")
    Sprint mapDtoToEntitySprint(SprintDto sprintDto);
    @Named("mapEntityListToDtoListSprint")
    @IterableMapping(qualifiedByName = "mapEntityToDtoSprint")
    List<SprintDto> mapEntityListToDtoListSprint(List<Sprint> sprints);
    @Named("mapEntityToDtoSlim")
    SprintDtoSlim mapEntityToDtoSlim(Sprint source);

    @Named("mapEntityListToDtoSlimListSprint")
    @IterableMapping(qualifiedByName = "mapEntityToDtoSlim")
    List<SprintDtoSlim> mapEntityListToDtoSlimListSprint(List<Sprint> sprints);
}
