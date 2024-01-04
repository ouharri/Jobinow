package com.ouharri.Jobinow.model.dto.requests;

import com.ouharri.Jobinow.model.dto.responses.CompanyResponse;
import com.ouharri.Jobinow.model.entities.VerificationCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for {@link VerificationCode}.
 * Represents a request for a verification code with a code and associated company.
 */
public record VerificationCodeRequest(
        @NotBlank(message = "Verification code cannot be blank")
        String code,

        @NotNull CompanyResponse company
) implements _Request {
}