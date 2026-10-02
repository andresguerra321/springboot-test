package com.backintro.domain.treatmentplan.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;

public record TreatmentPlanUpdatedEvent(
    TreatmentPlanId id,
    UUID encounterId,
    UUID professionalId,
    String title,
    String description,
    java.time.LocalDate startDate,
    java.time.LocalDate endDate,
    UUID treatmentStatusId,
    LocalDateTime occurredOn
) implements DomainEvent {

    public TreatmentPlanUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(encounterId, "encounterId must not be null");
        Objects.requireNonNull(professionalId, "professionalId must not be null");
        Objects.requireNonNull(title, "title must not be null");
        Objects.requireNonNull(treatmentStatusId, "treatmentStatusId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}