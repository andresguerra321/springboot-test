package com.backintro.application.patientallergy.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record PatientAllergyResponse(
        UUID id,
        UUID patientId,
        String patientName,
        String substance,
        String reaction,
        String severity,
        Boolean active,
        java.time.LocalDateTime recordedAt,
        UUID recordedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}