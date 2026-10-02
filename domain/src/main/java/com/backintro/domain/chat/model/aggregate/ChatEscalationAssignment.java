package com.backintro.domain.chat.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ChatEscalationAssignment {

    private UUID id;
    private UUID escalationId;
    private UUID professionalId;
    private LocalDateTime assignedAt;

    public ChatEscalationAssignment() {
    }

    public ChatEscalationAssignment(UUID id, UUID escalationId, UUID professionalId, LocalDateTime assignedAt) {
        this.id = id;
        this.escalationId = escalationId;
        this.professionalId = professionalId;
        this.assignedAt = assignedAt != null ? assignedAt : LocalDateTime.now();
    }

    public static ChatEscalationAssignment create(UUID escalationId, UUID professionalId) {
        return new ChatEscalationAssignment(UUID.randomUUID(), escalationId, professionalId, LocalDateTime.now());
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

    public UUID getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(UUID professionalId) {
        this.professionalId = professionalId;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationAssignment that = (ChatEscalationAssignment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
