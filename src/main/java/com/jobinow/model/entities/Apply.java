package com.jobinow.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

/**
 * Represents a job application entity in the system.
 * This class includes information about a job application,
 * such as the job seeker, associated job offer, and resume attachments.
 *
 * @version 1.0
 */
@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Apply extends AbstractEntity {

    /**
     * The job seeker who submitted the application.
     */
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User jobSeeker;

    /**
     * The job offer to which the application is submitted.
     */
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Offer Offer;

    /**
     * The set of resume attachments (PDFs) associated with the application.
     */
    @OneToMany
    private Set<Attachment> resumePdfs;
}