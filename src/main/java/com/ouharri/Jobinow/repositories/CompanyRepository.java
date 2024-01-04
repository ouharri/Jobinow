package com.ouharri.Jobinow.repositories;

import com.ouharri.Jobinow.model.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Spring Data JPA repository for the {@link Company} entity.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
}