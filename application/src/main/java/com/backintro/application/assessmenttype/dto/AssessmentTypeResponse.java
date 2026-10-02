package com.backintro.application.assessmenttype.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record AssessmentTypeResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}