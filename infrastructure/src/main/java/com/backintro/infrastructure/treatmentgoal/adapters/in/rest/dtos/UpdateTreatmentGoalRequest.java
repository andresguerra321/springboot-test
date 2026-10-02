package com.backintro.infrastructure.treatmentgoal.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateTreatmentGoalRequest(
        @jakarta.validation.constraints.NotNull(message = "treatmentPlanId is required")
        UUID treatmentPlanId,

        @NotBlank(message = "description is required")
        String description,

        java.time.LocalDate targetDate,

        java.time.LocalDateTime completedAt,

        String notes,

        @jakarta.validation.constraints.NotNull(message = "treatmentGoalStatusId is required")
        UUID treatmentGoalStatusId
) {}