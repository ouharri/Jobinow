package com.ouharri.Jobinow.model.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ouharri.Jobinow.model.entities.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * DTO for {@link AbstractEntity};
 * AbstractResponse serves as a base class for response DTOs.
 * It includes common fields such as id, createdAt, updatedAt, and version.
 * This class is intended to be extended by specific response DTOs in the system.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractResponse implements _Response {
    UUID id;
    Timestamp createdAt;
    Timestamp updatedAt;
    Long version;
}