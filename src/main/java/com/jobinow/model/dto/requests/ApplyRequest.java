package com.jobinow.model.dto.requests;

import com.jobinow.model.dto.responses.OfferResponse;
import com.jobinow.model.dto.responses.UserResponses;
import com.jobinow.model.entities.Apply;

import java.util.Set;

/**
 * DTO Request for {@link Apply}
 * <p>
 * Represents a request data transfer object for creating or updating an {@link Apply}.
 * It encapsulates the necessary information for applying to a job offer, including details
 * about the job seeker, the target job offer, and a set of attachment URLs.
 */
public record ApplyRequest(
        UserResponses jobSeeker,
        OfferResponse Offer,
        Set<AttachmentRequest> attachmentUrls
) implements _Request {
}