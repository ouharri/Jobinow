package com.ouharri.Jobinow.services.impl;

import com.ouharri.Jobinow.model.dto.requests.ProfilRequest;
import com.ouharri.Jobinow.model.dto.responses.ProfilResponse;
import com.ouharri.Jobinow.model.entities.Profil;
import com.ouharri.Jobinow.model.mapper.ProfilMapper;
import com.ouharri.Jobinow.repositories.ProfilRepository;
import com.ouharri.Jobinow.services.spec.ProfilService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfilServiceImp extends _ServiceImp<UUID, ProfilRequest, ProfilResponse, Profil, ProfilRepository, ProfilMapper> implements ProfilService {
}
