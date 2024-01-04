package com.ouharri.Jobinow.services.impl;

import com.ouharri.Jobinow.model.dto.requests.OffreRequest;
import com.ouharri.Jobinow.model.dto.responses.OffreResponse;
import com.ouharri.Jobinow.model.entities.Offre;
import com.ouharri.Jobinow.model.mapper.OffreMapper;
import com.ouharri.Jobinow.repositories.OffreRepository;
import com.ouharri.Jobinow.services.spec.OffreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OffreServiceImp extends _ServiceImp<UUID, OffreRequest, OffreResponse, Offre, OffreRepository, OffreMapper> implements OffreService {
}
