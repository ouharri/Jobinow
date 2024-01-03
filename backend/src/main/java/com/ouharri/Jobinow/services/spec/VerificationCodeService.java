package com.ouharri.Jobinow.services.spec;

import com.ouharri.Jobinow.model.dto.requests.VerificationCodeRequest;
import com.ouharri.Jobinow.model.entities.VerificationCode;

import java.util.Optional;

public interface VerificationCodeService {
    Optional<VerificationCode> createVerificationCode(VerificationCode verificationCode);

    Boolean isValidVerificationCode(VerificationCodeRequest verificationCode);
}
