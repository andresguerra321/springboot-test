package com.backintro.application.chatairun.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;

public record UpdateChatAiRunCommand(
        ChatAiRunId id,
        UUID conversationId,
        UUID messageId,
        UUID modelId,
        UUID aiRunStatusId
) {
    public UpdateChatAiRunCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(messageId, "messageId must not be null");
        Objects.requireNonNull(modelId, "modelId must not be null");
        Objects.requireNonNull(aiRunStatusId, "aiRunStatusId must not be null");
    }
}