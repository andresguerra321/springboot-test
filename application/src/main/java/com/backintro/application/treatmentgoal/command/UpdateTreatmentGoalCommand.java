package com.backintro.application.treatmentgoal.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;

public record UpdateTreatmentGoalCommand(
        TreatmentGoalId id,
        UUID treatmentPlanId,
        String description,
        java.time.LocalDate targetDate,
        java.time.LocalDateTime completedAt,
        String notes,
        UUID treatmentGoalStatusId
) {
    public UpdateTreatmentGoalCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(treatmentPlanId, "treatmentPlanId must not be null");
        Objects.requireNonNull(description, "description must not be null");
        Objects.requireNonNull(treatmentGoalStatusId, "treatmentGoalStatusId must not be null");
    }
}