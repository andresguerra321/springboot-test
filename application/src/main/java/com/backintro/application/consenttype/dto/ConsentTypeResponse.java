package com.backintro.application.consenttype.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ConsentTypeResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}