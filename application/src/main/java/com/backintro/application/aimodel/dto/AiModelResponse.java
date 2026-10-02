package com.backintro.application.aimodel.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record AiModelResponse(
        UUID id,
        UUID providerModelId,
        String providerModelName,
        String nameModel,
        String modelKey,
        java.math.BigDecimal inputTokenPrice,
        java.math.BigDecimal outputTokenPrice,
        Integer maxTokens,
        Integer contextWindow,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}