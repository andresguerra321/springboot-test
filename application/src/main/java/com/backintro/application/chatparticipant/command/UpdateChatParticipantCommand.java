package com.backintro.application.chatparticipant.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;

public record UpdateChatParticipantCommand(
        ChatParticipantId id,
        UUID conversationId,
        UUID participantTypeId,
        UUID patientId,
        UUID professionalId
) {
    public UpdateChatParticipantCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(participantTypeId, "participantTypeId must not be null");
    }
}