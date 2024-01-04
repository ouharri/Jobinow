package com.ouharri.Jobinow.model.mapper;

import com.ouharri.Jobinow.model.dto.requests.OffreRequest;
import com.ouharri.Jobinow.model.dto.responses.OffreResponse;
import com.ouharri.Jobinow.model.entities.Offre;
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
