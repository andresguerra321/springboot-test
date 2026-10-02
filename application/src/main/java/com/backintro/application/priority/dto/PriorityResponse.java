package com.backintro.application.priority.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record PriorityResponse(
        UUID id,
        String namePriority,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}