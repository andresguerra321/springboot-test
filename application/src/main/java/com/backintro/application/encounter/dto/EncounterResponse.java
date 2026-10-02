package com.backintro.application.encounter.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record EncounterResponse(
        UUID id,
        UUID clinicalRecordId,
        UUID professionalId,
        String professionalName,
        UUID encounterTypeId,
        String encounterTypeName,
        java.time.LocalDateTime startedAt,
        java.time.LocalDateTime endedAt,
        String reasonForVisit,
        String currentCondition,
        UUID modalityId,
        String modalityName,
        UUID statusId,
        String statusName,
        UUID createdBy,
        UUID updatedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}