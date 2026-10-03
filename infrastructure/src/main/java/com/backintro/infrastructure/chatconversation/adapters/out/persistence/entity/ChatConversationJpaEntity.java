package com.backintro.infrastructure.chatconversation.adapters.out.persistence.entity;

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
@Table(name = "chat_conversations")
public class ChatConversationJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "conversation_status_id", nullable = false)
    private UUID conversationStatusId;
    @Column(name = "priority_id", nullable = false)
    private UUID priorityId;
    @Column(name = "last_message_at", nullable = true)
    private java.time.LocalDateTime lastMessageAt;
    @Column(name = "closed", nullable = true)
    private boolean closed;
    @Column(name = "closed_at", nullable = true)
    private java.time.LocalDateTime closedAt;
    @Column(name = "closed_by", nullable = true)
    private UUID closedBy;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public ChatConversationJpaEntity() {}

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

    public UUID getConversationStatusId() {
        return conversationStatusId;
    }
    public void setConversationStatusId(UUID conversationStatusId) {
        this.conversationStatusId = conversationStatusId;
    }
    public UUID getPriorityId() {
        return priorityId;
    }
    public void setPriorityId(UUID priorityId) {
        this.priorityId = priorityId;
    }
    public java.time.LocalDateTime getLastMessageAt() {
        return lastMessageAt;
    }
    public void setLastMessageAt(java.time.LocalDateTime lastMessageAt) {
        this.lastMessageAt = lastMessageAt;
    }
    public boolean isClosed() {
        return closed;
    }
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
    public java.time.LocalDateTime getClosedAt() {
        return closedAt;
    }
    public void setClosedAt(java.time.LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }
    public UUID getClosedBy() {
        return closedBy;
    }
    public void setClosedBy(UUID closedBy) {
        this.closedBy = closedBy;
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatConversationJpaEntity that = (ChatConversationJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}