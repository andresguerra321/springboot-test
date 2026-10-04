package com.backintro.infrastructure.encounter.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateEncounterRequest(
        @NotNull(message = "clinicalRecordId is required")
        UUID clinicalRecordId,

        @NotNull(message = "professionalId is required")
        UUID professionalId,

        @NotNull(message = "encounterTypeId is required")
        UUID encounterTypeId,

        @NotNull(message = "startedAt is required")


        java.time.LocalDateTime startedAt,

        java.time.LocalDateTime endedAt,

        String reasonForVisit,

        String currentCondition,

        @NotNull(message = "modalityId is required")
        UUID modalityId,

        @NotNull(message = "statusId is required")
        UUID statusId,

        UUID createdBy,

        UUID updatedBy
) {}