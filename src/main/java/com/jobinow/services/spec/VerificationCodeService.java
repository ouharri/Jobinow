package com.jobinow.services.spec;

import com.jobinow.model.entities.VerificationCode;
import com.jobinow.model.dto.requests.VerificationCodeRequest;

import java.util.Optional;

public interface VerificationCodeService {
    Optional<VerificationCode> createVerificationCode(VerificationCode verificationCode);

    Boolean isValidVerificationCode(VerificationCodeRequest verificationCode);
}
