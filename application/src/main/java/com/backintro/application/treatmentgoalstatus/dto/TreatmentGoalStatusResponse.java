package com.backintro.application.treatmentgoalstatus.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record TreatmentGoalStatusResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}