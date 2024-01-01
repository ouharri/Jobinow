package com.ouharri.Jobinow.model.mapper;

import com.ouharri.Jobinow.model.dto.requests.TagRequest;
import com.ouharri.Jobinow.model.dto.responses.TagResponse;
import com.ouharri.Jobinow.model.entities.Tag;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * Mapper interface for converting between {@link TagRequest}, {@link TagResponse}, and {@link Tag} entities.
 * Extends the generic {@link _Mapper} interface with UUID as the identifier type.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface TagMapper extends _Mapper<UUID, TagRequest, TagResponse, Tag> {
}