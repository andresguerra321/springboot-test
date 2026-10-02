package com.backintro.application.encounter.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterEncounterCommand(
        UUID clinicalRecordId,
        UUID professionalId,
        UUID encounterTypeId,
        java.time.LocalDateTime startedAt,
        java.time.LocalDateTime endedAt,
        String reasonForVisit,
        String currentCondition,
        UUID modalityId,
        UUID statusId,
        UUID createdBy,
        UUID updatedBy
) {
    public RegisterEncounterCommand {
        Objects.requireNonNull(clinicalRecordId, "clinicalRecordId must not be null");
        Objects.requireNonNull(professionalId, "professionalId must not be null");
        Objects.requireNonNull(encounterTypeId, "encounterTypeId must not be null");
        Objects.requireNonNull(startedAt, "startedAt must not be null");
        Objects.requireNonNull(modalityId, "modalityId must not be null");
        Objects.requireNonNull(statusId, "statusId must not be null");
    }
}