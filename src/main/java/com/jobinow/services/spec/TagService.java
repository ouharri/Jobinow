package com.jobinow.services.spec;

import com.jobinow.model.dto.requests.TagRequest;
import com.jobinow.model.dto.responses.TagResponse;

import java.util.UUID;

/**
 * Service interface for managing tags.
 * This service extends the generic service interface {@link _Service},
 * specializing in operations related to tag entities.
 * It defines methods for creating, retrieving, and handling
 * other aspects of tag data.
 * <p>
 * The interface is designed to work with UUID as the identifier type for tag entities.
 * </p>
 *
 * @version 1.0
 * @see TagRequest
 * @see TagResponse
 * @see _Service
 */
public interface TagService extends _Service<UUID, TagRequest, TagResponse> {
}