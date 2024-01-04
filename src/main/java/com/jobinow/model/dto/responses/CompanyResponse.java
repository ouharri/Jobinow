package com.jobinow.model.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jobinow.model.dto.basic.AddressDto;
import com.jobinow.model.entities.Company;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

/**
 * DTO for representing a response related to {@link Company}.
 * This DTO includes information such as the company name, email, phone number, image URL, address, and common response fields.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyResponse extends AbstractResponse {
    @NotBlank(message = "Company name cannot be blank")
    String name;

    @Email(message = "Email address must be valid")
    String email;

    @Pattern(message = "Phone number must have exactly 10 digits", regexp = "\\d{10}")
    String phoneNumber;

    @URL(message = "Image URL must be valid")
    String imageUrl;

    AddressDto address;
}