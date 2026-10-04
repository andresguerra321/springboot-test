package com.backintro.infrastructure.aimodel.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateAiModelRequest(
        @NotNull(message = "providerModelId is required")
        UUID providerModelId,

        @NotBlank(message = "nameModel is required")
        String nameModel,

        @NotBlank(message = "modelKey is required")
        String modelKey,

        java.math.BigDecimal inputTokenPrice,

        java.math.BigDecimal outputTokenPrice,

        Integer maxTokens,

        Integer contextWindow
) {}