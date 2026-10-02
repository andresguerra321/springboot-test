package com.backintro.application.professional.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.professional.model.valueobject.ProfessionalId;

public record UpdateProfessionalCommand(
        ProfessionalId id,
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String lastName,
        UUID professionalTypeId,
        String licenseNumber,
        UUID cityId
) {
    public UpdateProfessionalCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(documentTypeId, "documentTypeId must not be null");
        Objects.requireNonNull(documentNumber, "documentNumber must not be null");
        Objects.requireNonNull(firstName, "firstName must not be null");
        Objects.requireNonNull(lastName, "lastName must not be null");
        Objects.requireNonNull(professionalTypeId, "professionalTypeId must not be null");
    }
}