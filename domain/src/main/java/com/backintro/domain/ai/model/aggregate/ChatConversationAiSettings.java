package com.backintro.domain.ai.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ChatConversationAiSettings {

    private UUID id;
    private UUID conversationId;
    private Boolean aiEnabled;
    private UUID defaultModelId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ChatConversationAiSettings() {
    }

    public ChatConversationAiSettings(UUID id, UUID conversationId, Boolean aiEnabled, UUID defaultModelId,
                                      LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.conversationId = conversationId;
        this.aiEnabled = aiEnabled != null ? aiEnabled : Boolean.TRUE;
        this.defaultModelId = defaultModelId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static ChatConversationAiSettings create(UUID conversationId, Boolean aiEnabled, UUID defaultModelId) {
        LocalDateTime now = LocalDateTime.now();
        return new ChatConversationAiSettings(UUID.randomUUID(), conversationId, aiEnabled, defaultModelId, now, now);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getConversationId() {
        return conversationId;
    }

    public void setConversationId(UUID conversationId) {
        this.conversationId = conversationId;
    }

    public Boolean getAiEnabled() {
        return aiEnabled;
    }

    public void setAiEnabled(Boolean aiEnabled) {
        this.aiEnabled = aiEnabled;
    }

    public UUID getDefaultModelId() {
        return defaultModelId;
    }

    public void setDefaultModelId(UUID defaultModelId) {
        this.defaultModelId = defaultModelId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatConversationAiSettings that = (ChatConversationAiSettings) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
