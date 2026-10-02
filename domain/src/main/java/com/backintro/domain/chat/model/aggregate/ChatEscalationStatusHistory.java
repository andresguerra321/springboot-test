package com.backintro.domain.chat.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ChatEscalationStatusHistory {

    private UUID id;
    private UUID escalationId;
    private UUID escalationStatusId;
    private LocalDateTime createdAt;
    private LocalDateTime changedAt;

    public ChatEscalationStatusHistory() {
    }

    public ChatEscalationStatusHistory(UUID id, UUID escalationId, UUID escalationStatusId,
                                       LocalDateTime createdAt, LocalDateTime changedAt) {
        this.id = id;
        this.escalationId = escalationId;
        this.escalationStatusId = escalationStatusId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.changedAt = changedAt != null ? changedAt : LocalDateTime.now();
    }

    public static ChatEscalationStatusHistory create(UUID escalationId, UUID escalationStatusId) {
        LocalDateTime now = LocalDateTime.now();
        return new ChatEscalationStatusHistory(UUID.randomUUID(), escalationId, escalationStatusId, now, now);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getEscalationId() {
        return escalationId;
    }

    public void setEscalationId(UUID escalationId) {
        this.escalationId = escalationId;
    }

    public UUID getEscalationStatusId() {
        return escalationStatusId;
    }

    public void setEscalationStatusId(UUID escalationStatusId) {
        this.escalationStatusId = escalationStatusId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationStatusHistory that = (ChatEscalationStatusHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
