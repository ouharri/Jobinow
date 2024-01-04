package com.jobinow.model.dto.requests;

import com.jobinow.validations.Annotation.ConfirmationPasswordLikePassword;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO class representing a user registration request.
 * Contains fields for the first name, last name, email, password, and confirmation password.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 * @version 1.0
 */
@ConfirmationPasswordLikePassword
public record RegisterRequest(
        @NotNull(message = "First name cannot be null")
        @Size(min = 1, message = "First name cannot be empty")
        @Size(max = 30, message = "First name is too long")
        String firstname,

        @Size(max = 30, message = "Last name is too long")
        String lastname,

        @NotNull(message = "Email cannot be null")
        @Email(message = "Email was not provided")
        @Size(max = 80, message = "Email is too long")
        @Column(unique = true, table = "_user")
        String email,

        @NotNull(message = "Password cannot be null")
        @NotEmpty(message = "Password cannot be empty")
        @Size(min = 8, message = "Password is too short")
        String password,

        @NotNull(message = "Password confirmation cannot be null")
        @NotEmpty(message = "Password confirmation cannot be empty")
        @Size(min = 8, message = "Password confirmation is too short")
        String confirmationPassword
) implements _Request {
}
