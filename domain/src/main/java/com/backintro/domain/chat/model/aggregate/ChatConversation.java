package com.backintro.domain.chat.model.aggregate;

import com.backintro.domain.common.model.AggregateRoot;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ChatConversation extends AggregateRoot {

    private UUID id;
    private UUID conversationStatusId;
    private UUID priorityId;
    private LocalDateTime lastMessageAt;
    private Boolean closed;
    private LocalDateTime closedAt;
    private UUID closedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ChatConversation() {
    }

    public ChatConversation(UUID id, UUID conversationStatusId, UUID priorityId, LocalDateTime lastMessageAt,
                            Boolean closed, LocalDateTime closedAt, UUID closedBy,
                            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.conversationStatusId = conversationStatusId;
        this.priorityId = priorityId;
        this.lastMessageAt = lastMessageAt;
        this.closed = closed != null ? closed : Boolean.FALSE;
        this.closedAt = closedAt;
        this.closedBy = closedBy;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static ChatConversation create(UUID conversationStatusId, UUID priorityId) {
        LocalDateTime now = LocalDateTime.now();
        return new ChatConversation(
                UUID.randomUUID(),
                conversationStatusId,
                priorityId,
                null,
                Boolean.FALSE,
                null,
                null,
                now,
                now
        );
    }

    public void close(UUID closedBy) {
        this.closed = Boolean.TRUE;
        this.closedAt = LocalDateTime.now();
        this.closedBy = closedBy;
        this.updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public LocalDateTime getLastMessageAt() {
        return lastMessageAt;
    }

    public void setLastMessageAt(LocalDateTime lastMessageAt) {
        this.lastMessageAt = lastMessageAt;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }

    public UUID getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(UUID closedBy) {
        this.closedBy = closedBy;
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
        ChatConversation that = (ChatConversation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
