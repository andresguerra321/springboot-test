package com.backintro.application.patient.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterPatientCommand(
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        java.time.LocalDate birthDate,
        UUID biologicalSexId,
        UUID genderIdentity,
        String email,
        String phone,
        String address,
        UUID cityId,
        UUID createdBy,
        UUID updatedBy
) {
    public RegisterPatientCommand {
        Objects.requireNonNull(documentTypeId, "documentTypeId must not be null");
        Objects.requireNonNull(documentNumber, "documentNumber must not be null");
        Objects.requireNonNull(firstName, "firstName must not be null");
        Objects.requireNonNull(lastName, "lastName must not be null");
        Objects.requireNonNull(biologicalSexId, "biologicalSexId must not be null");
    }
}