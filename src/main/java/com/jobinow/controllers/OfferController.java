package com.jobinow.controllers;

import com.jobinow.model.dto.requests.OfferRequest;
import com.jobinow.model.dto.responses.OfferResponse;
import com.jobinow.services.spec.OfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequestMapping("api/v2/Offer")
public class OfferController extends _Controller<UUID, OfferRequest, OfferResponse, OfferService> {
}
