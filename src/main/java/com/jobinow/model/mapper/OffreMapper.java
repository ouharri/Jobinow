package com.jobinow.model.mapper;

import com.jobinow.model.dto.requests.OffreRequest;
import com.jobinow.model.dto.responses.OffreResponse;
import com.jobinow.model.entities.Offre;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * Mapper interface for converting between {@link OffreRequest}, {@link OffreResponse}, and {@link Offre} entities.
 * Extends the generic {@link _Mapper} interface with UUID as the identifier type.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface OffreMapper extends _Mapper<UUID, OffreRequest, OffreResponse, Offre> {
}
