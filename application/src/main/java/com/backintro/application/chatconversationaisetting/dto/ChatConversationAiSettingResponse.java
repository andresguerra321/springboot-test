package com.backintro.application.chatconversationaisetting.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ChatConversationAiSettingResponse(
        UUID id,
        UUID conversationId,
        boolean aiEnabled,
        UUID defaultModelId,
        String defaultModelName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}