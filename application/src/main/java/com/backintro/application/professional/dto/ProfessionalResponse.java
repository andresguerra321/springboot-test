package com.backintro.application.professional.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ProfessionalResponse(
        UUID id,
        UUID documentTypeId,
        String documentTypeName,
        String documentNumber,
        String firstName,
        String lastName,
        UUID professionalTypeId,
        String professionalTypeName,
        String licenseNumber,
        UUID cityId,
        String cityName,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}