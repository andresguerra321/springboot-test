package com.backintro.domain.professional.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;

public record ProfessionalUpdatedEvent(
    ProfessionalId id,
    UUID documentTypeId,
    String documentNumber,
    String firstName,
    String lastName,
    UUID professionalTypeId,
    String licenseNumber,
    UUID cityId,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ProfessionalUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(documentTypeId, "documentTypeId must not be null");
        Objects.requireNonNull(documentNumber, "documentNumber must not be null");
        Objects.requireNonNull(firstName, "firstName must not be null");
        Objects.requireNonNull(lastName, "lastName must not be null");
        Objects.requireNonNull(professionalTypeId, "professionalTypeId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}