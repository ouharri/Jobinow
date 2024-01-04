package com.ouharri.Jobinow.repositories;

import com.ouharri.Jobinow.model.entities.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * This interface extends JpaRepository to inherit basic CRUD operations for VerificationCode entities.
 */
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, UUID> {

    /**
     * Custom query to check the validity of a verification code.
     *
     * @param verificationCode The verification code to check.
     * @param companyId        The ID of the company associated with the verification code.
     * @return True if the verification code is valid, false otherwise.
     */
    @Query("SELECT CASE WHEN COUNT(vc) > 0 THEN true ELSE false END " +
            "FROM VerificationCode vc " +
            "WHERE vc.code = :verificationCode " +
            "AND vc.company.id = :companyId " +
            "AND (TIMESTAMPDIFF(SECOND, vc.createdAt, CURRENT_TIMESTAMP) <= 180) ")
    Boolean isValidVerificationCode(@Param("verificationCode") String verificationCode, @Param("companyId") UUID companyId);

}