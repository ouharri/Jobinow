package com.jobinow.model.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jobinow.model.entities.VerificationCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * DTO for representing a response related to {@link VerificationCode}.
 * This DTO includes information such as the verification code, company, and common response fields.
 **/
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationCodeResponse extends AbstractResponse {
    @NotBlank(message = "Verification code cannot be blank")
    String code;

    @NotNull CompanyResponse company;
}