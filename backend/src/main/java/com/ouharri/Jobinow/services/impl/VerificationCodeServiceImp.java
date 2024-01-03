package com.ouharri.Jobinow.services.impl;

import com.ouharri.Jobinow.exceptions.ResourceNotCreatedException;
import com.ouharri.Jobinow.model.dto.requests.VerificationCodeRequest;
import com.ouharri.Jobinow.model.entities.VerificationCode;
import com.ouharri.Jobinow.model.mapper.VerificationCodeMapper;
import com.ouharri.Jobinow.repositories.VerificationCodeRepository;
import com.ouharri.Jobinow.services.spec.VerificationCodeService;
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
