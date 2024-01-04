package com.ouharri.Jobinow.model.mapper;

import com.ouharri.Jobinow.model.dto.requests.CompanyRequest;
import com.ouharri.Jobinow.model.dto.responses.CompanyResponse;
import com.ouharri.Jobinow.model.entities.Company;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * Mapper interface for converting between {@link CompanyRequest}, {@link CompanyResponse}, and {@link Company} entities.
 * Extends the generic {@link _Mapper} interface with UUID as the identifier type.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface CompanyMapper extends _Mapper<UUID, CompanyRequest, CompanyResponse, Company> {
}
