package com.jobinow.model.mapper;

import com.jobinow.model.dto.requests.OfferRequest;
import com.jobinow.model.dto.responses.OfferResponse;
import com.jobinow.model.entities.Offer;
import org.mapstruct.*;

import java.lang.annotation.Target;
import java.util.UUID;

/**
 * Mapper interface for converting between {@link OfferRequest}, {@link OfferResponse}, and {@link Offer} entities.
 * Extends the generic {@link _Mapper} interface with UUID as the identifier type.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface OfferMapper extends _Mapper<UUID, OfferRequest, OfferResponse, Offer> {
    @Override
    @Mapping(target = "recruiter", source = "recruiter")
    Offer toEntityFromRequest(OfferRequest request);
}