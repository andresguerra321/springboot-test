package com.backintro.application.treatmentplan.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record TreatmentPlanResponse(
        UUID id,
        UUID encounterId,
        UUID professionalId,
        String professionalName,
        String title,
        String description,
        java.time.LocalDate startDate,
        java.time.LocalDate endDate,
        UUID treatmentStatusId,
        String treatmentStatusName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}