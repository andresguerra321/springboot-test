package com.backintro.application.chatairunmetric.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterChatAiRunMetricCommand(
        UUID aiRunId,
        Integer promptTokens,
        Integer completionTokens,
        Integer totalTokens,
        java.math.BigDecimal cost
) {
    public RegisterChatAiRunMetricCommand {
        Objects.requireNonNull(aiRunId, "aiRunId must not be null");
    }
}