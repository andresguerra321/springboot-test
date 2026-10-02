package com.backintro.application.encountermodality.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record EncounterModalityResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}