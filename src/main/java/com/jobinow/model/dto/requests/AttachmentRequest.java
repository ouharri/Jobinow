package com.jobinow.model.dto.requests;

import com.jobinow.model.entities.Attachment;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;

/**
 * DTO Request for {@link Attachment}
 * <p>
 * Represents a request data transfer object for creating or updating an {@link Attachment}.
 * It encapsulates the necessary information for attaching a URL to a resource.
 */
public record AttachmentRequest(
        @NotNull
        @URL(message = "Attachment URL must be valid")
        String attachmentUrl
) implements Serializable {
}