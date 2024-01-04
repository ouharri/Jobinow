package com.jobinow.controllers;

import com.jobinow.model.dto.requests.TagRequest;
import com.jobinow.model.dto.responses.TagResponse;
import com.jobinow.services.spec.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequestMapping("api/v2/tag")
public class TagController extends _Controller<UUID, TagRequest, TagResponse, TagService> {
}