package com.backintro.application.chatairunerror.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterChatAiRunErrorCommand(
        UUID aiRunId,
        String errorMessage,
        String errorCode,
        String providerErrorId
) {
    public RegisterChatAiRunErrorCommand {
        Objects.requireNonNull(aiRunId, "aiRunId must not be null");
    }
}