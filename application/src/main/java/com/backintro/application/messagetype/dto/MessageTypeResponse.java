package com.backintro.application.messagetype.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record MessageTypeResponse(
        UUID id,
        String nameType,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}