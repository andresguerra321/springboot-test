package com.backintro.application.chatairunmetric.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

public record UpdateChatAiRunMetricCommand(
        ChatAiRunMetricId id,
        UUID aiRunId,
        Integer promptTokens,
        Integer completionTokens,
        Integer totalTokens,
        java.math.BigDecimal cost
) {
    public UpdateChatAiRunMetricCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(aiRunId, "aiRunId must not be null");
    }
}