package com.example.springprojectlbd.mapper;

import com.example.springprojectlbd.dto.AttachmentDto;
import com.example.springprojectlbd.entity.Attachment;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AttachmentMapper {

    @Named("mapToDtoAttachment")
    AttachmentDto mapToDtoAttachment(Attachment source);

    @Named("mapEntityToDtoList")
    @IterableMapping(qualifiedByName = "mapToDtoAttachment")
    Set<AttachmentDto> mapToDtoAttachmentList(Set<Attachment> attachments);
}
