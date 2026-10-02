package com.backintro.infrastructure.chatparticipant.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateChatParticipantRequest(
        @jakarta.validation.constraints.NotNull(message = "conversationId is required")
        UUID conversationId,

        @jakarta.validation.constraints.NotNull(message = "participantTypeId is required")
        UUID participantTypeId,

        UUID patientId,

        UUID professionalId
) {}