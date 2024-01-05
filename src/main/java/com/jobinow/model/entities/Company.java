package com.jobinow.model.entities;

import com.jobinow.model.enums.CompanyStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.validator.constraints.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Represents a company entity in the system.
 * This class includes information about a company such as its name, email, phone number, image URL,
 * address, recruiters, manager, and associated job offers.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 * @version 1.0
 */
@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Company extends AbstractEntity {

    /**
     * The name of the company.
     */
    @NotBlank(message = "Company name cannot be blank")
    private String name;

    /**
     * The email address of the company.
     */
    @Email(message = "Email address must be valid")
    private String email;

    /**
     * The phone number of the company.
     */
    @Pattern(regexp = "\\d{10}", message = "Phone number must have exactly 10 digits")
    private String phoneNumber;

    /**
     * The URL to the company's image.
     */
    @URL(message = "Image URL must be valid")
    private String imageUrl;

    /**
     * The address of the company.
     */
    @Embedded
    private Address address = new Address();

    /**
     * The status of the company.
     */
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private CompanyStatus status = CompanyStatus.PENDING;

    /**
     * The list of verification codes associated with the company.
     */
    @OneToMany(
            mappedBy = "company"
    )
    private List<VerificationCode> verificationCodes = new ArrayList<>();

    /**
     * The list of recruiters associated with the company.
     */
    @OneToMany(
            mappedBy = "recruitedCompanies"
    )
    private List<User> recruiters = new ArrayList<>();

    /**
     * The manager associated with the company.
     */
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "id"
    )
    private User manager;

    /**
     * The list of job offers associated with the company.
     */
    @OneToMany(
            mappedBy = "company"
    )
    private List<Offer> Offers;

    /**
     * The set of resume PDF attachments associated with the company.
     */
    @OneToMany
    private Set<Attachment> resumePdfs;
}