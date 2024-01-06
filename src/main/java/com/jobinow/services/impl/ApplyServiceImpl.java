package com.jobinow.services.impl;

import com.jobinow.model.dto.requests.ApplyRequest;
import com.jobinow.model.dto.responses.ApplyResponse;
import com.jobinow.model.entities.Apply;
import com.jobinow.model.mapper.ApplyMapper;
import com.jobinow.repositories.ApplyRepository;
import com.jobinow.services.spec.ApplyService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Implementation of the {@link ApplyService} interface providing functionality for applying to job offers.
 * This class extends the generic service implementation {@link _ServiceImp}.
 *
 * @see ApplyService
 * @see _ServiceImp
 */
@Service
public class ApplyServiceImpl extends _ServiceImp<UUID, ApplyRequest, ApplyResponse, Apply, ApplyRepository, ApplyMapper> implements ApplyService {

}
