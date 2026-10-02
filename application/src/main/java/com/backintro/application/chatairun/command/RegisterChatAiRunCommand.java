package com.backintro.application.chatairun.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterChatAiRunCommand(
        UUID conversationId,
        UUID messageId,
        UUID modelId,
        UUID aiRunStatusId
) {
    public RegisterChatAiRunCommand {
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(messageId, "messageId must not be null");
        Objects.requireNonNull(modelId, "modelId must not be null");
        Objects.requireNonNull(aiRunStatusId, "aiRunStatusId must not be null");
    }
}