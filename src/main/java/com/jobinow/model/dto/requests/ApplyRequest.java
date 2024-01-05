package com.jobinow.model.dto.requests;

import com.jobinow.model.dto.responses.AttachmentResponse;
import com.jobinow.model.dto.responses.OfferResponse;
import com.jobinow.model.dto.responses.UserResponses;
import com.jobinow.model.entities.Apply;

import java.util.Set;

/**
 * DTO Request for {@link Apply}
 */
public record ApplyRequest(
        UserResponses jobSeeker,
        OfferResponse Offer,
        Set<AttachmentResponse> attachmentUrls
) implements _Request {
}