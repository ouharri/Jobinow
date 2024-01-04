package com.jobinow.services.impl;

import com.jobinow.model.entities.Offre;
import com.jobinow.services.spec.OffreService;
import com.jobinow.model.dto.requests.OffreRequest;
import com.jobinow.model.dto.responses.OffreResponse;
import com.jobinow.model.mapper.OffreMapper;
import com.jobinow.repositories.OffreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OffreServiceImp extends _ServiceImp<UUID, OffreRequest, OffreResponse, Offre, OffreRepository, OffreMapper> implements OffreService {
}
