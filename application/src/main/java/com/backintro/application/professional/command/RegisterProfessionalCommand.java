package com.backintro.application.professional.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterProfessionalCommand(
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String lastName,
        UUID professionalTypeId,
        String licenseNumber,
        UUID cityId
) {
    public RegisterProfessionalCommand {
        Objects.requireNonNull(documentTypeId, "documentTypeId must not be null");
        Objects.requireNonNull(documentNumber, "documentNumber must not be null");
        Objects.requireNonNull(firstName, "firstName must not be null");
        Objects.requireNonNull(lastName, "lastName must not be null");
        Objects.requireNonNull(professionalTypeId, "professionalTypeId must not be null");
    }
}