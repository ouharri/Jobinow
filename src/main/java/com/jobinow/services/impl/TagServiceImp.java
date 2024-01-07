package com.jobinow.services.impl;

import com.jobinow.model.dto.requests.TagRequest;
import com.jobinow.model.dto.responses.TagResponse;
import com.jobinow.model.entities.Tag;
import com.jobinow.model.mapper.TagMapper;
import com.jobinow.repositories.TagRepository;
import com.jobinow.services.spec.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service implementation class for managing tags.
 * This service provides methods for creating, updating, and retrieving operations related to {@link Tag}.
 * It extends the generic service implementation ({@link _ServiceImp}) and leverages the {@link TagMapper}
 * for mapping between entities and DTOs.
 * <p>
 * The class handles operations such as creating, updating, and retrieving tags, using the specified
 * repository ({@link TagRepository}) for data access.
 * </p>

 *
 * @version 1.0
 * @see _ServiceImp
 * @see Tag
 * @see TagRequest
 * @see TagResponse
 * @see TagMapper
 * @see TagRepository
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TagServiceImp extends _ServiceImp<UUID, TagRequest, TagResponse, Tag, TagRepository, TagMapper> implements TagService {
}