package com.backintro.application.chatmessage.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterChatMessageCommand(
        UUID conversationId,
        UUID messageTypeId,
        UUID participantId,
        String content,
        String metadata
) {
    public RegisterChatMessageCommand {
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(messageTypeId, "messageTypeId must not be null");
        Objects.requireNonNull(participantId, "participantId must not be null");
    }
}