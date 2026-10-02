package com.backintro.application.conversationstatus.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ConversationStatusResponse(
        UUID id,
        String nameStatus,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}