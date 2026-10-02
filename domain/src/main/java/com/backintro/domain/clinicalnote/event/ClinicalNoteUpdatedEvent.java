package com.backintro.domain.clinicalnote.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;

public record ClinicalNoteUpdatedEvent(
    ClinicalNoteId id,
    UUID encounterId,
    UUID professionalId,
    String subjective,
    String objective,
    String assessment,
    String plan,
    String additionalNotes,
    java.time.LocalDateTime signedAt,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ClinicalNoteUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(encounterId, "encounterId must not be null");
        Objects.requireNonNull(professionalId, "professionalId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}