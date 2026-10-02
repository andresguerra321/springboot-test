package com.backintro.application.patient.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record PatientResponse(
        UUID id,
        UUID documentTypeId,
        String documentTypeName,
        String documentNumber,
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        java.time.LocalDate birthDate,
        UUID biologicalSexId,
        String biologicalSexName,
        UUID genderIdentity,
        String genderIdentityName,
        String email,
        String phone,
        String address,
        boolean active,
        UUID cityId,
        String cityName,
        UUID createdBy,
        UUID updatedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}