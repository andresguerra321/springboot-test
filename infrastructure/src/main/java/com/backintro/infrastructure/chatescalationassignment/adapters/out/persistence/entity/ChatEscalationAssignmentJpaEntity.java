package com.backintro.infrastructure.chatescalationassignment.adapters.out.persistence.entity;

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
@Table(name = "chat_escalation_assignments")
public class ChatEscalationAssignmentJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "escalation_id", nullable = false)
    private UUID escalationId;
    @Column(name = "professional_id", nullable = false)
    private UUID professionalId;
    @Column(name = "assigned_at", nullable = false)
    private java.time.LocalDateTime assignedAt;

    public ChatEscalationAssignmentJpaEntity() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getEscalationId() {
        return escalationId;
    }
    public void setEscalationId(UUID escalationId) {
        this.escalationId = escalationId;
    }
    public UUID getProfessionalId() {
        return professionalId;
    }
    public void setProfessionalId(UUID professionalId) {
        this.professionalId = professionalId;
    }
    public java.time.LocalDateTime getAssignedAt() {
        return assignedAt;
    }
    public void setAssignedAt(java.time.LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationAssignmentJpaEntity that = (ChatEscalationAssignmentJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}