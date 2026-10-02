package com.backintro.infrastructure.chatairun.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat_ai_runs")
public class ChatAiRunJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "conversation_id", nullable = false)
    private UUID conversationId;
    @Column(name = "message_id", nullable = false)
    private UUID messageId;
    @Column(name = "model_id", nullable = false)
    private UUID modelId;
    @Column(name = "ai_run_status_id", nullable = false)
    private UUID aiRunStatusId;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public ChatAiRunJpaEntity() {}

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) this.createdAt = LocalDateTime.now();
        if (this.updatedAt == null) this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

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
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunJpaEntity that = (ChatAiRunJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}