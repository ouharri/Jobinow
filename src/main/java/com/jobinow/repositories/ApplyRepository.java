package com.jobinow.repositories;

import com.jobinow.model.entities.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyRepository extends JpaRepository<Apply, UUID> {
}