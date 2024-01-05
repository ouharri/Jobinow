package com.jobinow.repositories;

import com.jobinow.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobSeekerRepository extends JpaRepository<User, UUID> {
    
}
