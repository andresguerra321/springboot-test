package com.backintro.application.treatmentgoal.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterTreatmentGoalCommand(
        UUID treatmentPlanId,
        String description,
        java.time.LocalDate targetDate,
        java.time.LocalDateTime completedAt,
        String notes,
        UUID treatmentGoalStatusId
) {
    public RegisterTreatmentGoalCommand {
        Objects.requireNonNull(treatmentPlanId, "treatmentPlanId must not be null");
        Objects.requireNonNull(description, "description must not be null");
        Objects.requireNonNull(treatmentGoalStatusId, "treatmentGoalStatusId must not be null");
    }
}