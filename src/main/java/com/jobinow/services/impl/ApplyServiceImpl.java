package com.jobinow.services.impl;

import com.jobinow.model.dto.requests.ApplyRequest;
import com.jobinow.model.dto.requests.CompanyRequest;
import com.jobinow.model.dto.responses.ApplyResponse;
import com.jobinow.model.dto.responses.CompanyResponse;
import com.jobinow.model.entities.Apply;
import com.jobinow.model.entities.Company;
import com.jobinow.model.mapper.ApplyMapper;
import com.jobinow.model.mapper.CompanyMapper;
import com.jobinow.repositories.ApplyRepository;
import com.jobinow.repositories.CompanyRepository;
import com.jobinow.services.spec.ApplyService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyServiceImpl extends _ServiceImp<UUID, ApplyRequest, ApplyResponse, Apply, ApplyRepository, ApplyMapper> implements ApplyService {

}
