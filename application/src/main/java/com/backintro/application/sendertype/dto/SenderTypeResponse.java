package com.backintro.application.sendertype.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record SenderTypeResponse(
        UUID id,
        String nameType,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}