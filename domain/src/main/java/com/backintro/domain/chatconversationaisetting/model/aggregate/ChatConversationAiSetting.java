package com.backintro.domain.chatconversationaisetting.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatconversationaisetting.event.ChatConversationAiSettingRegisteredEvent;
import com.backintro.domain.chatconversationaisetting.event.ChatConversationAiSettingUpdatedEvent;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;

public class ChatConversationAiSetting extends AggregateRoot {
    private final ChatConversationAiSettingId id;
    private UUID conversationId;
    private boolean aiEnabled;
    private UUID defaultModelId;

    private ChatConversationAiSetting(
        ChatConversationAiSettingId id,
        UUID conversationId,
        boolean aiEnabled,
        UUID defaultModelId) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.aiEnabled = Objects.requireNonNull(aiEnabled, "aiEnabled must not be null");
        this.defaultModelId = defaultModelId;
    }

    public static ChatConversationAiSetting register(
        UUID conversationId,
        boolean aiEnabled,
        UUID defaultModelId) {

        ChatConversationAiSettingId id = ChatConversationAiSettingId.generate();

        ChatConversationAiSetting entity = new ChatConversationAiSetting(
            id,
            conversationId,
            aiEnabled,
            defaultModelId);

        entity.recordEvent(
            new ChatConversationAiSettingRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ChatConversationAiSetting restore(
        ChatConversationAiSettingId id,
        UUID conversationId,
        boolean aiEnabled,
        UUID defaultModelId) {
        return new ChatConversationAiSetting(
            id,
            conversationId,
            aiEnabled,
            defaultModelId);
    }

    public void update(
        UUID conversationId,
        boolean aiEnabled,
        UUID defaultModelId) {

        this.conversationId = Objects.requireNonNull(conversationId);
        this.aiEnabled = Objects.requireNonNull(aiEnabled);
        this.defaultModelId = defaultModelId;

        recordEvent(
            new ChatConversationAiSettingUpdatedEvent(
                this.id,
                this.conversationId,
                this.aiEnabled,
                this.defaultModelId,
                LocalDateTime.now()));
    }

    public ChatConversationAiSettingId id() {
        return id;
    }

    public UUID conversationId() {
        return conversationId;
    }
    public boolean aiEnabled() {
        return aiEnabled;
    }
    public UUID defaultModelId() {
        return defaultModelId;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ChatConversationAiSettingId getId() {
        return id();
    }

    public UUID getConversationId() {
        return conversationId();
    }
    public boolean isAiEnabled() {
        return aiEnabled();
    }
    public UUID getDefaultModelId() {
        return defaultModelId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatConversationAiSetting that = (ChatConversationAiSetting) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ChatConversationAiSetting{" +
                "id=" + id +
                '}';
    }
}