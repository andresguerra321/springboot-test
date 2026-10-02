package com.backintro.application.chatairunerror.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ChatAiRunErrorResponse(
        UUID id,
        UUID aiRunId,
        String errorMessage,
        String errorCode,
        String providerErrorId,
        LocalDateTime createdAt
) {
}