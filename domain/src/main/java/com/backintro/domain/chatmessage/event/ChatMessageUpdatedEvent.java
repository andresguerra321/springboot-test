package com.backintro.domain.chatmessage.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;

public record ChatMessageUpdatedEvent(
    ChatMessageId id,
    UUID conversationId,
    UUID messageTypeId,
    UUID participantId,
    String content,
    String metadata,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ChatMessageUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(messageTypeId, "messageTypeId must not be null");
        Objects.requireNonNull(participantId, "participantId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}