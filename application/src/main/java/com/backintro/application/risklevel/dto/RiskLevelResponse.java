package com.backintro.application.risklevel.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record RiskLevelResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        Integer severity,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}