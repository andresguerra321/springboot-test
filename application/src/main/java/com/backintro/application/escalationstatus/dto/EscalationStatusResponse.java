package com.backintro.application.escalationstatus.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record EscalationStatusResponse(
        UUID id,
        String nameStatus,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}