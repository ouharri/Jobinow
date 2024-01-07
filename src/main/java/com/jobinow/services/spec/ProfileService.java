package com.jobinow.services.spec;

import com.jobinow.model.dto.requests.ProfilRequest;
import com.jobinow.model.dto.responses.ProfilResponse;

import java.util.UUID;

/**
 * Service interface for managing job profiles.
 * This service extends the generic service interface {@link _Service},
 * specializing in operations related to job profile entities.
 * It defines methods for creating, retrieving, and handling
 * other aspects of job profile data.
 * <p>
 * The interface is designed to work with UUID as the identifier type for job profile entities.
 * </p>
 *
 * @version 1.0
 * @see ProfilRequest
 * @see ProfilResponse
 * @see _Service
 */
public interface ProfileService extends _Service<UUID, ProfilRequest, ProfilResponse> {
}