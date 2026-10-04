package com.backintro.domain.patientcontact.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;

public record PatientContactUpdatedEvent(
    PatientContactId id,
    UUID contactId,
    UUID patientId,
    Boolean primaryContact,
    Boolean emergencyContact,
    UUID relationshipTypeId,
    LocalDateTime occurredOn
) implements DomainEvent {

    public PatientContactUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(contactId, "contactId must not be null");
        Objects.requireNonNull(patientId, "patientId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}