package com.backintro.application.chatconversation.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;

public record UpdateChatConversationCommand(
        ChatConversationId id,
        UUID conversationStatusId,
        UUID priorityId,
        java.time.LocalDateTime lastMessageAt,
        Boolean closed,
        java.time.LocalDateTime closedAt,
        UUID closedBy
) {
    public UpdateChatConversationCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(conversationStatusId, "conversationStatusId must not be null");
        Objects.requireNonNull(priorityId, "priorityId must not be null");
    }
}