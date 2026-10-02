package com.backintro.application.encounterstatus.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record EncounterStatusResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}