package com.jobinow.model.dto.requests;

import com.jobinow.model.entities.Offre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * DTO for representing a request related to {@link Offre}.
 * This DTO includes information such as the job title, description, location, degree,
 * and salary for creating or updating a job offer.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 */
public record OffreRequest(
        @NotBlank(message = "Job title cannot be blank")
        String title,

        @NotBlank(message = "Job description cannot be blank")
        String description,

        @NotBlank(message = "Job location cannot be blank")
        String location,

        @NotBlank(message = "Degree requirements cannot be blank")
        String degree,

        @PositiveOrZero(message = "Salary must be a non-negative value")
        Double salary
) implements _Request {
}