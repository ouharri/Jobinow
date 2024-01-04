package com.ouharri.Jobinow.repositories;

import com.ouharri.Jobinow.model.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Spring Data JPA repository for the {@link Tag} entity.
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {
}