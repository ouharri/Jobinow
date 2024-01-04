package com.jobinow.model.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jobinow.model.entities.Offer;
import com.jobinow.model.enums.OfferStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * DTO for representing a response related to {@link Offer}.
 * This DTO includes information such as the job title, description, location, degree, salary, status,
 * associated profiles, associated company, associated tags, and common response fields.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferResponse extends AbstractResponse {
    @NotBlank(message = "Job title cannot be blank")
    String title;

    @NotBlank(message = "Job description cannot be blank")
    String description;

    @NotBlank(message = "Job location cannot be blank")
    String location;

    @NotBlank(message = "Degree requirements cannot be blank")
    String degree;

    @PositiveOrZero(message = "Salary must be a non-negative value")
    Double salary;

    @NotNull(message = "Job status cannot be null")
    OfferStatus status;

    List<ProfilResponse> profils;

    CompanyResponse company;

    List<TagResponse> tags;

}