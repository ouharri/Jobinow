package com.jobinow.model.dto.requests;

import com.jobinow.model.entities.Profil;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO for representing a request related to {@link Profil}.
 * This DTO includes information such as the profile title and description for creating or updating a profile.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 */

public record ProfilRequest(
        @NotBlank(message = "Profile title cannot be blank")
        String title,

        String description
) implements _Request {
}