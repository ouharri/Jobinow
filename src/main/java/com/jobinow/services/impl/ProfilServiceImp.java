package com.jobinow.services.impl;

import com.jobinow.model.dto.requests.ProfilRequest;
import com.jobinow.model.dto.responses.ProfilResponse;
import com.jobinow.model.entities.Profil;
import com.jobinow.model.mapper.ProfilMapper;
import com.jobinow.repositories.ProfilRepository;
import com.jobinow.services.spec.ProfilService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfilServiceImp extends _ServiceImp<UUID, ProfilRequest, ProfilResponse, Profil, ProfilRepository, ProfilMapper> implements ProfilService {
}
