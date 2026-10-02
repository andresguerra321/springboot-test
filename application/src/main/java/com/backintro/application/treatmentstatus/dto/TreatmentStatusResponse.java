package com.backintro.application.treatmentstatus.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record TreatmentStatusResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}