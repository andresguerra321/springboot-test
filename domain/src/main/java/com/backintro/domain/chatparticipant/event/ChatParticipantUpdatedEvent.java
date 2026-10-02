package com.backintro.domain.chatparticipant.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;

public record ChatParticipantUpdatedEvent(
    ChatParticipantId id,
    UUID conversationId,
    UUID participantTypeId,
    UUID patientId,
    UUID professionalId,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ChatParticipantUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(participantTypeId, "participantTypeId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}