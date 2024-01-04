package com.ouharri.Jobinow.model.dto.requests;

import com.ouharri.Jobinow.model.entities.Tag;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO for representing a request related to {@link Tag}.
 * This DTO includes information such as the tag title and description for creating or updating a tag.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 */
public record TagRequest(
        @NotBlank(message = "Tag title cannot be blank")
        String title,

        String description
) implements _Request {
}