package com.jobinow.controllers;

import com.jobinow.model.dto.requests.ProfilRequest;
import com.jobinow.model.dto.responses.ProfilResponse;
import com.jobinow.services.spec.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequestMapping("api/v2/profil")
public class ProfilController extends _Controller<UUID, ProfilRequest, ProfilResponse, ProfileService> {
}
