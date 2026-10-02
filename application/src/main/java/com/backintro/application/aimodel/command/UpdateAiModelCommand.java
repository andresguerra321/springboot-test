package com.backintro.application.aimodel.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.aimodel.model.valueobject.AiModelId;

public record UpdateAiModelCommand(
        AiModelId id,
        UUID providerModelId,
        String nameModel,
        String modelKey,
        java.math.BigDecimal inputTokenPrice,
        java.math.BigDecimal outputTokenPrice,
        Integer maxTokens,
        Integer contextWindow
) {
    public UpdateAiModelCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(providerModelId, "providerModelId must not be null");
        Objects.requireNonNull(nameModel, "nameModel must not be null");
        Objects.requireNonNull(modelKey, "modelKey must not be null");
    }
}