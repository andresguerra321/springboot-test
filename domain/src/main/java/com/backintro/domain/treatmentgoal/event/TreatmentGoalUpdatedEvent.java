package com.backintro.domain.treatmentgoal.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;

public record TreatmentGoalUpdatedEvent(
    TreatmentGoalId id,
    UUID treatmentPlanId,
    String description,
    java.time.LocalDate targetDate,
    java.time.LocalDateTime completedAt,
    String notes,
    UUID treatmentGoalStatusId,
    LocalDateTime occurredOn
) implements DomainEvent {

    public TreatmentGoalUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(treatmentPlanId, "treatmentPlanId must not be null");
        Objects.requireNonNull(description, "description must not be null");
        Objects.requireNonNull(treatmentGoalStatusId, "treatmentGoalStatusId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}