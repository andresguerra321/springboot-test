package com.backintro.domain.ai.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ChatAiRun {

    private UUID id;
    private UUID conversationId;
    private UUID messageId;
    private UUID modelId;
    private UUID aiRunStatusId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ChatAiRun() {
    }

    public ChatAiRun(UUID id, UUID conversationId, UUID messageId, UUID modelId,
                     UUID aiRunStatusId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.conversationId = conversationId;
        this.messageId = messageId;
        this.modelId = modelId;
        this.aiRunStatusId = aiRunStatusId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static ChatAiRun create(UUID conversationId, UUID messageId, UUID modelId, UUID aiRunStatusId) {
        LocalDateTime now = LocalDateTime.now();
        return new ChatAiRun(UUID.randomUUID(), conversationId, messageId, modelId, aiRunStatusId, now, now);
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

    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    public UUID getModelId() {
        return modelId;
    }

    public void setModelId(UUID modelId) {
        this.modelId = modelId;
    }

    public UUID getAiRunStatusId() {
        return aiRunStatusId;
    }

    public void setAiRunStatusId(UUID aiRunStatusId) {
        this.aiRunStatusId = aiRunStatusId;
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
        ChatAiRun chatAiRun = (ChatAiRun) o;
        return Objects.equals(id, chatAiRun.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
