package com.backintro.application.professionaltype.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ProfessionalTypeResponse(
        UUID id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}