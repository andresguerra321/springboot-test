package com.backintro.application.airunstatus.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record AiRunStatusResponse(
        UUID id,
        String nameStatus,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}