package com.jobinow.repositories;

import com.jobinow.model.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Spring Data JPA repository for the {@link Offre} entity.
 */
@Repository
public interface OffreRepository extends JpaRepository<Offre, UUID> {
}