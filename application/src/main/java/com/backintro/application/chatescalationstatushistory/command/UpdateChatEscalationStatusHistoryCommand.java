package com.backintro.application.chatescalationstatushistory.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

public record UpdateChatEscalationStatusHistoryCommand(
        ChatEscalationStatusHistoryId id,
        UUID escalationId,
        UUID escalationStatusId,
        java.time.LocalDateTime changedAt
) {
    public UpdateChatEscalationStatusHistoryCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(escalationId, "escalationId must not be null");
        Objects.requireNonNull(escalationStatusId, "escalationStatusId must not be null");
        Objects.requireNonNull(changedAt, "changedAt must not be null");
    }
}