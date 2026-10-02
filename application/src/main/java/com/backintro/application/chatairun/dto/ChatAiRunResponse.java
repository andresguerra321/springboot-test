package com.backintro.application.chatairun.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ChatAiRunResponse(
        UUID id,
        UUID conversationId,
        UUID messageId,
        UUID modelId,
        String modelName,
        UUID aiRunStatusId,
        String aiRunStatusName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}