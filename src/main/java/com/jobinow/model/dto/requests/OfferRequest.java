package com.jobinow.model.dto.requests;

import com.jobinow.model.dto.responses.UserResponses;
import com.jobinow.model.entities.Offer;
import com.jobinow.model.entities.User;
import com.jobinow.model.mapper.UserMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * DTO for representing a request related to {@link Offer}.
 * This DTO includes information such as the job title, description, location, degree,
 * and salary for creating or updating a job offer.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 */
public record OfferRequest(
        @NotBlank(message = "Job title cannot be blank")
        String title,

        @NotBlank(message = "Job description cannot be blank")
        String description,

        @NotBlank(message = "Job location cannot be blank")
        String location,

        @NotBlank(message = "Degree requirements cannot be blank")
        String degree,

        @PositiveOrZero(message = "Salary must be a non-negative value")
        Double salary,

        @NotBlank(message = "recruiter requirements cannot be blank")
        UserResponses recruiter
) implements _Request {
}