package com.backintro.infrastructure.chatairunmetric.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateChatAiRunMetricRequest(
        @jakarta.validation.constraints.NotNull(message = "aiRunId is required")
        UUID aiRunId,

        Integer promptTokens,

        Integer completionTokens,

        Integer totalTokens,

        java.math.BigDecimal cost
) {}