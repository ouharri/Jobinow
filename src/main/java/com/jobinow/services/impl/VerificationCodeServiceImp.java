package com.jobinow.services.impl;

import com.jobinow.exceptions.ResourceNotCreatedException;
import com.jobinow.model.entities.VerificationCode;
import com.jobinow.services.spec.VerificationCodeService;
import com.jobinow.model.dto.requests.VerificationCodeRequest;
import com.jobinow.model.mapper.VerificationCodeMapper;
import com.jobinow.repositories.VerificationCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VerificationCodeServiceImp implements VerificationCodeService {

    private final VerificationCodeMapper mapper;
    private final VerificationCodeRepository repository;

    public Optional<VerificationCode> createVerificationCode(VerificationCode verificationCode) {
        try {
            return Optional.of(repository.saveAndFlush(verificationCode));
        } catch (Exception e) {
            log.error("Error while creating VerificationCode", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
    }

    public Boolean isValidVerificationCode(VerificationCodeRequest verificationCode) {
        VerificationCode verificationCodeToCreate = mapper.toEntityFromRequest(verificationCode);
        return repository.isValidVerificationCode(
                verificationCodeToCreate.getCode(),
                verificationCodeToCreate.getCompany().getId()
        );
    }
}
