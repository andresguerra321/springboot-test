package com.backintro.application.contact.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ContactResponse(
        UUID id,
        String fullName,
        String email,
        String notes,
        UUID cityId,
        String cityName,
        UUID createdBy,
        UUID updatedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}