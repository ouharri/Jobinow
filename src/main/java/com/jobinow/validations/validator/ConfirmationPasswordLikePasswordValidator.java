package com.jobinow.validations.validator;

import com.jobinow.model.dto.requests.RegisterRequest;
import com.jobinow.validations.Annotation.ConfirmationPasswordLikePassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator to check if the password in a {@link RegisterRequest} matches the confirmation password.
 */
public class ConfirmationPasswordLikePasswordValidator implements ConstraintValidator<ConfirmationPasswordLikePassword, RegisterRequest> {

    /**
     * Validates whether the password in the {@link RegisterRequest} matches the confirmation password.
     *
     * @param request The {@link RegisterRequest} object to validate.
     * @param context The validation context.
     * @return True if the password matches the confirmation password, false otherwise.
     */
    @Override
    public boolean isValid(RegisterRequest request, ConstraintValidatorContext context) {
        if (request == null) {
            return false;
        }

        String password = request.password();
        String confirmationPassword = request.confirmationPassword();

        return password != null && password.equals(confirmationPassword);
    }
}