package com.jobinow.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * Represents a verification code associated with a company.
 *
 * <p>This entity is mapped to the "verification_codes" table in the database.
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "verification_codes")
public class VerificationCode extends AbstractEntity {

    /**
     * The verification code. Must not be blank.
     */
    @NotBlank(message = "Verification code cannot be blank")
    private String code;

    /**
     * The company associated with this verification code.
     */
    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Company.class
    )
    @JoinColumn(name = "company_id")
    private Company company;
}
