package com.backintro.application.encountertype.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record EncounterTypeResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}