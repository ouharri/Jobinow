package com.jobinow.services.impl;

import com.jobinow.model.dto.requests.TagRequest;
import com.jobinow.model.dto.responses.TagResponse;
import com.jobinow.model.entities.Tag;
import com.jobinow.model.mapper.TagMapper;
import com.jobinow.repositories.TagRepository;
import com.jobinow.services.spec.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagServiceImp extends _ServiceImp<UUID, TagRequest, TagResponse, Tag, TagRepository, TagMapper> implements TagService {
}
