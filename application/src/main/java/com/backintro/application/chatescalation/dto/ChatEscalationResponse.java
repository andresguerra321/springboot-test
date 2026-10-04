package com.backintro.application.chatescalation.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ChatEscalationResponse(
        UUID id,
        UUID conversationId,
        UUID statusId,
        String statusName,
        Boolean fromAi,
        String reason,
        LocalDateTime createdAt
) {
}