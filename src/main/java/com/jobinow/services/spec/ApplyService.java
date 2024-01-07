package com.jobinow.services.spec;

import com.jobinow.model.dto.requests.ApplyRequest;
import com.jobinow.model.dto.responses.ApplyResponse;

import java.util.UUID;

/**
 * Service interface for managing job applications.
 * This service extends the generic service interface {@link _Service},
 * specializing in operations related to applying for job positions.
 * It defines methods for handling the lifecycle of job applications,
 * including creation, retrieval, and response generation.
 * <p>
 * The interface is designed to work with UUID as the identifier type for apply entities.
 * </p>
 *
 * @version 1.0
 * @see ApplyRequest
 * @see ApplyResponse
 * @see _Service
 */
public interface ApplyService extends _Service<UUID, ApplyRequest, ApplyResponse> {
}