package com.jobinow.services.spec;

import com.jobinow.model.dto.requests.OfferRequest;
import com.jobinow.model.dto.responses.OfferResponse;

import java.util.UUID;

/**
 * Service interface for managing job offers.
 * This service extends the generic service interface {@link _Service},
 * specializing in operations related to job offer entities.
 * It defines methods for creating, retrieving, and handling
 * other aspects of job offer data.
 * <p>
 * The interface is designed to work with UUID as the identifier type for job offer entities.
 * </p>
 *
 * @version 1.0
 * @see OfferRequest
 * @see OfferResponse
 * @see _Service
 */
public interface OfferService extends _Service<UUID, OfferRequest, OfferResponse> {
}