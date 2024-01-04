package com.jobinow.model.entities;

import com.jobinow.model.enums.OffreStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a job offer entity in the system.
 * This class includes information about a job offer such as its title, description, location, degree,
 * salary, status, associated company, recruiter, and tags.
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
public class Offre extends AbstractEntity {

    /**
     * The title of the job offer.
     */
    @NotBlank(message = "Job title cannot be blank")
    private String title;

    /**
     * The description of the job offer.
     */
    @NotBlank(message = "Job description cannot be blank")
    private String description;

    /**
     * The location of the job offer.
     */
    @NotBlank(message = "Job location cannot be blank")
    private String location;

    /**
     * The degree required for the job offer.
     */
    @NotBlank(message = "Degree requirements cannot be blank")
    private String degree;

    /**
     * The salary offered for the job.
     */
    @PositiveOrZero(message = "Salary must be a non-negative value")
    private Double salary;

    /**
     * The status of the job offer.
     */
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private OffreStatus status = OffreStatus.PENDING;

    /**
     * The list of profils associated with the job offer.
     */
    @ManyToMany
    private List<Profil> profils = new ArrayList<>();

    /**
     * The company associated with the job offer.
     */
    @ManyToOne
    @JoinTable(name = "company_offres")
    private Company company;

    /**
     * The recruiter associated with the job offer.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recruiter_id", referencedColumnName = "id")
    @NotNull(message = "recruiter cannot be null")
    private User recruiter;

    /**
     * The list of tags associated with the job offer.
     */
    @ManyToMany
    private List<Tag> tags = new ArrayList<>();
}