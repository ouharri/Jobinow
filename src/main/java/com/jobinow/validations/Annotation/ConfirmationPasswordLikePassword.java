package com.jobinow.validations.Annotation;

import com.jobinow.validations.validator.ConfirmationPasswordLikePasswordValidator;
import com.jobinow.validations.validator.EndTimeAfterStartTimeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation for validating that the confirmation password is like the original password.
 * Uses the {@link EndTimeAfterStartTimeValidator} for validation logic.
 *
 * @author <a href="mailto:your-email@example.com">Your Name</a>
 * @version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmationPasswordLikePasswordValidator.class)
public @interface ConfirmationPasswordLikePassword {

    /**
     * The default error message when validation fails.
     *
     * @return The error message.
     */
    String message() default "The confirmation password must be like the password.";

    /**
     * Groups the constraint belongs to.
     *
     * @return An array of groups.
     */
    Class<?>[] groups() default {};

    /**
     * Payload type that can be attached to a given constraint declaration.
     *
     * @return An array of payload classes.
     */
    Class<? extends Payload>[] payload() default {};
}