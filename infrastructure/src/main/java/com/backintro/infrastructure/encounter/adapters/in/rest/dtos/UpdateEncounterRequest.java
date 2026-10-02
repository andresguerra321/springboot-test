package com.backintro.infrastructure.encounter.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateEncounterRequest(
        @jakarta.validation.constraints.NotNull(message = "clinicalRecordId is required")
        UUID clinicalRecordId,

        @jakarta.validation.constraints.NotNull(message = "professionalId is required")
        UUID professionalId,

        @jakarta.validation.constraints.NotNull(message = "encounterTypeId is required")
        UUID encounterTypeId,

        java.time.LocalDateTime startedAt,

        java.time.LocalDateTime endedAt,

        String reasonForVisit,

        String currentCondition,

        @jakarta.validation.constraints.NotNull(message = "modalityId is required")
        UUID modalityId,

        @jakarta.validation.constraints.NotNull(message = "statusId is required")
        UUID statusId,

        UUID createdBy,

        UUID updatedBy
) {}