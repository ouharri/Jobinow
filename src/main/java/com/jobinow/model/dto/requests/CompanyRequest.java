package com.jobinow.model.dto.requests;

import com.jobinow.model.dto.basic.AddressDto;
import com.jobinow.model.entities.Company;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;

/**
 * DTO for representing a request related to {@link Company}.
 * This DTO includes information such as the company name, email, phone number, image URL,
 * and address for creating or updating a company.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 */

public record CompanyRequest(
        @NotBlank(message = "Company name cannot be blank")
        String name,

        @Email(message = "Email address must be valid")
        String email,

        @Pattern(message = "Phone number must have exactly 10 digits", regexp = "\\d{10}")
        String phoneNumber,

        @URL(message = "Image URL must be valid")
        String imageUrl,

        AddressDto address
) implements _Request {
}