package com.backintro.application.chatairunmetric.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ChatAiRunMetricResponse(
        UUID id,
        UUID aiRunId,
        Integer promptTokens,
        Integer completionTokens,
        Integer totalTokens,
        java.math.BigDecimal cost,
        LocalDateTime createdAt
) {
}