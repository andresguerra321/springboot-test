package com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.entity;

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
@Table(name = "chat_escalation_status_history")
public class ChatEscalationStatusHistoryJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "escalation_id", nullable = false)
    private UUID escalationId;
    @Column(name = "escalation_status_id", nullable = false)
    private UUID escalationStatusId;
    @Column(name = "changed_at", nullable = false)
    private java.time.LocalDateTime changedAt;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public ChatEscalationStatusHistoryJpaEntity() {}

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) this.createdAt = LocalDateTime.now();
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

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
    public java.time.LocalDateTime getChangedAt() {
        return changedAt;
    }
    public void setChangedAt(java.time.LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationStatusHistoryJpaEntity that = (ChatEscalationStatusHistoryJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}