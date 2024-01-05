package com.jobinow.controllers;

import com.jobinow.model.dto.requests.ApplyRequest;
import com.jobinow.model.dto.responses.ApplyResponse;
import com.jobinow.services.spec.ApplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequestMapping("api/v2/apply")
public class ApplyController extends _Controller<UUID, ApplyRequest, ApplyResponse, ApplyService> {
}
