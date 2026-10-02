package com.backintro.application.chatmessage.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;

public record UpdateChatMessageCommand(
        ChatMessageId id,
        UUID conversationId,
        UUID messageTypeId,
        UUID participantId,
        String content,
        String metadata
) {
    public UpdateChatMessageCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(messageTypeId, "messageTypeId must not be null");
        Objects.requireNonNull(participantId, "participantId must not be null");
    }
}