package com.backintro.application.chatairunerror.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

public record UpdateChatAiRunErrorCommand(
        ChatAiRunErrorId id,
        UUID aiRunId,
        String errorMessage,
        String errorCode,
        String providerErrorId
) {
    public UpdateChatAiRunErrorCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(aiRunId, "aiRunId must not be null");
    }
}