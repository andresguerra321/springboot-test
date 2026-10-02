package com.backintro.application.treatmentgoal.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record TreatmentGoalResponse(
        UUID id,
        UUID treatmentPlanId,
        String description,
        java.time.LocalDate targetDate,
        java.time.LocalDateTime completedAt,
        String notes,
        UUID treatmentGoalStatusId,
        String treatmentGoalStatusName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}