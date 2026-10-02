package com.backintro.application.aimodel.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterAiModelCommand(
        UUID providerModelId,
        String nameModel,
        String modelKey,
        java.math.BigDecimal inputTokenPrice,
        java.math.BigDecimal outputTokenPrice,
        Integer maxTokens,
        Integer contextWindow
) {
    public RegisterAiModelCommand {
        Objects.requireNonNull(providerModelId, "providerModelId must not be null");
        Objects.requireNonNull(nameModel, "nameModel must not be null");
        Objects.requireNonNull(modelKey, "modelKey must not be null");
    }
}