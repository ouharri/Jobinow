package com.ouharri.Jobinow.services.impl;

import com.ouharri.Jobinow.model.dto.requests.TagRequest;
import com.ouharri.Jobinow.model.dto.responses.TagResponse;
import com.ouharri.Jobinow.model.entities.Tag;
import com.ouharri.Jobinow.model.mapper.TagMapper;
import com.ouharri.Jobinow.repositories.TagRepository;
import com.ouharri.Jobinow.services.spec.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagServiceImp extends _ServiceImp<UUID, TagRequest, TagResponse, Tag, TagRepository, TagMapper> implements TagService {
}
