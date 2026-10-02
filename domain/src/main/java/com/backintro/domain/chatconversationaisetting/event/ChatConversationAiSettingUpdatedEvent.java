package com.backintro.domain.chatconversationaisetting.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;

public record ChatConversationAiSettingUpdatedEvent(
    ChatConversationAiSettingId id,
    UUID conversationId,
    boolean aiEnabled,
    UUID defaultModelId,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ChatConversationAiSettingUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(aiEnabled, "aiEnabled must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}