package com.backintro.application.chatparticipant.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterChatParticipantCommand(
        UUID conversationId,
        UUID participantTypeId,
        UUID patientId,
        UUID professionalId
) {
    public RegisterChatParticipantCommand {
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(participantTypeId, "participantTypeId must not be null");
    }
}