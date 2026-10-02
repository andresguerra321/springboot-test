package com.backintro.domain.clinicalrecord.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;

public record ClinicalRecordUpdatedEvent(
    ClinicalRecordId id,
    UUID patientId,
    java.time.LocalDateTime creationDate,
    String recordNumber,
    java.time.LocalDateTime openedAt,
    java.time.LocalDateTime closedAt,
    UUID statusId,
    UUID createdBy,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ClinicalRecordUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(patientId, "patientId must not be null");
        Objects.requireNonNull(recordNumber, "recordNumber must not be null");
        Objects.requireNonNull(statusId, "statusId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}