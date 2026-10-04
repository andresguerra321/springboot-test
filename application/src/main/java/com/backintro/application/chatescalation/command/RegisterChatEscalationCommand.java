package com.backintro.application.chatescalation.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterChatEscalationCommand(
        UUID conversationId,
        UUID statusId,
        Boolean fromAi,
        String reason
) {
    public RegisterChatEscalationCommand {
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(statusId, "statusId must not be null");
    }
}