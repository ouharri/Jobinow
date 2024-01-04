package com.ouharri.Jobinow.controllers;

import com.ouharri.Jobinow.model.dto.requests.ProfilRequest;
import com.ouharri.Jobinow.model.dto.responses.ProfilResponse;
import com.ouharri.Jobinow.services.spec.ProfilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequestMapping("api/v2/profil")
public class ProfilController extends _Controller<UUID, ProfilRequest, ProfilResponse, ProfilService> {
}
