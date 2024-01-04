package com.ouharri.Jobinow.repositories;

import com.ouharri.Jobinow.model.entities.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Spring Data JPA repository for the {@link Profil} entity.
 */
@Repository
public interface ProfilRepository extends JpaRepository<Profil, UUID> {
}