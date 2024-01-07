package com.jobinow.services.impl;

import com.jobinow.model.dto.requests.OfferRequest;
import com.jobinow.model.dto.responses.OfferResponse;
import com.jobinow.model.entities.Offer;
import com.jobinow.model.mapper.OfferMapper;
import com.jobinow.repositories.OfferRepository;
import com.jobinow.services.spec.OfferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service implementation class for managing job offers.
 * This service provides methods for creating, updating, and retrieving operations related to {@link Offer}.
 * It extends the generic service implementation ({@link _ServiceImp}) and leverages the {@link OfferMapper}
 * for mapping between entities and DTOs.
 * <p>
 * The class handles operations such as creating, updating, and retrieving job offers, using the specified
 * repository ({@link OfferRepository}) for data access.
 * </p>
 *
 * @author <a href="mailto:ouharrioutman@gmail.com">ouharri outman</a>
 * @version 1.0
 * @see _ServiceImp
 * @see Offer
 * @see OfferRequest
 * @see OfferResponse
 * @see OfferMapper
 * @see OfferRepository
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OfferServiceImp extends _ServiceImp<UUID, OfferRequest, OfferResponse, Offer, OfferRepository, OfferMapper> implements OfferService {
}