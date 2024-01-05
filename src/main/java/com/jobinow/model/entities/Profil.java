package com.jobinow.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a profile entity in the system.
 * This class includes information about a profile such as its title, description, and associated job offers.
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
public class Profil extends AbstractEntity {

    /**
     * The title of the profile.
     */
    @NotBlank(message = "Profile title cannot be blank")
    private String title;

    /**
     * The description of the profile.
     */
    private String description;

    /**
     * The list of job offers associated with the profile.
     */
    @ManyToMany
    private List<Offer> Offers = new ArrayList<>();
}