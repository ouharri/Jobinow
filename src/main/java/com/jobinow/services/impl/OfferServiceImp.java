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

@Slf4j
@Service
@RequiredArgsConstructor
public class OfferServiceImp extends _ServiceImp<UUID, OfferRequest, OfferResponse, Offer, OfferRepository, OfferMapper> implements OfferService {
}
