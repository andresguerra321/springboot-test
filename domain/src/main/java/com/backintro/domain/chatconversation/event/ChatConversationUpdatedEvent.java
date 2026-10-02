package com.backintro.domain.chatconversation.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;

public record ChatConversationUpdatedEvent(
    ChatConversationId id,
    UUID conversationStatusId,
    UUID priorityId,
    java.time.LocalDateTime lastMessageAt,
    boolean closed,
    java.time.LocalDateTime closedAt,
    UUID closedBy,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ChatConversationUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(conversationStatusId, "conversationStatusId must not be null");
        Objects.requireNonNull(priorityId, "priorityId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}