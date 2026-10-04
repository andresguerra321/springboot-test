package com.backintro.application.chatconversation.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterChatConversationCommand(
        UUID conversationStatusId,
        UUID priorityId,
        java.time.LocalDateTime lastMessageAt,
        Boolean closed,
        java.time.LocalDateTime closedAt,
        UUID closedBy
) {
    public RegisterChatConversationCommand {
        Objects.requireNonNull(conversationStatusId, "conversationStatusId must not be null");
        Objects.requireNonNull(priorityId, "priorityId must not be null");
    }
}