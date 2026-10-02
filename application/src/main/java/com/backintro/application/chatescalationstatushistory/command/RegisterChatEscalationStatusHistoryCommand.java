package com.backintro.application.chatescalationstatushistory.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterChatEscalationStatusHistoryCommand(
        UUID escalationId,
        UUID escalationStatusId,
        java.time.LocalDateTime changedAt
) {
    public RegisterChatEscalationStatusHistoryCommand {
        Objects.requireNonNull(escalationId, "escalationId must not be null");
        Objects.requireNonNull(escalationStatusId, "escalationStatusId must not be null");
        Objects.requireNonNull(changedAt, "changedAt must not be null");
    }
}