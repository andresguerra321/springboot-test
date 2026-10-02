package com.backintro.application.chatescalation.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;

public record UpdateChatEscalationCommand(
        ChatEscalationId id,
        UUID conversationId,
        UUID statusId,
        boolean fromAi,
        String reason
) {
    public UpdateChatEscalationCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(statusId, "statusId must not be null");
    }
}