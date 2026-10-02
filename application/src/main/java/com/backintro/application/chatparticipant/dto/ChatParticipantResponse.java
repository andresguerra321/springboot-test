package com.backintro.application.chatparticipant.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ChatParticipantResponse(
        UUID id,
        UUID conversationId,
        UUID participantTypeId,
        String participantTypeName,
        UUID patientId,
        UUID professionalId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}