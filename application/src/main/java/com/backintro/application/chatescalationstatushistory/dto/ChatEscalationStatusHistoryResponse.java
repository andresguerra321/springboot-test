package com.backintro.application.chatescalationstatushistory.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ChatEscalationStatusHistoryResponse(
        UUID id,
        UUID escalationId,
        UUID escalationStatusId,
        String escalationStatusName,
        java.time.LocalDateTime changedAt,
        LocalDateTime createdAt
) {
}