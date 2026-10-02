package com.backintro.domain.patientallergy.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;

public record PatientAllergyUpdatedEvent(
    PatientAllergyId id,
    UUID patientId,
    String substance,
    String reaction,
    String severity,
    java.time.LocalDateTime recordedAt,
    UUID recordedBy,
    LocalDateTime occurredOn
) implements DomainEvent {

    public PatientAllergyUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(patientId, "patientId must not be null");
        Objects.requireNonNull(substance, "substance must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}