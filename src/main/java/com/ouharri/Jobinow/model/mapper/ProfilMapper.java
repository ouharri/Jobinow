package com.ouharri.Jobinow.model.mapper;

import com.ouharri.Jobinow.model.dto.requests.ProfilRequest;
import com.ouharri.Jobinow.model.dto.responses.ProfilResponse;
import com.ouharri.Jobinow.model.entities.Profil;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * Mapper interface for converting between {@link ProfilRequest}, {@link ProfilResponse}, and {@link Profil} entities.
 * Extends the generic {@link _Mapper} interface with UUID as the identifier type.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ProfilMapper extends _Mapper<UUID, ProfilRequest, ProfilResponse, Profil> {
}
