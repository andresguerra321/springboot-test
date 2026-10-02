package com.backintro.application.medicationroute.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record MedicationRouteResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}