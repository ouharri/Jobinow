package com.jobinow.model.mapper;

import com.jobinow.model.dto.requests.VerificationCodeRequest;
import com.jobinow.model.dto.responses.VerificationCodeResponse;
import com.jobinow.model.entities.VerificationCode;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * Mapper interface for converting between {@link VerificationCodeRequest}, {@link VerificationCodeResponse}, and {@link VerificationCode} entities.
 * Extends the generic {@link _Mapper} interface with UUID as the identifier type.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface VerificationCodeMapper extends _Mapper<UUID, VerificationCodeRequest, VerificationCodeResponse, VerificationCode> {
}