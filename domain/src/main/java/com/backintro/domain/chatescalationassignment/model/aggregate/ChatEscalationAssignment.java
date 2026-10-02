package com.backintro.domain.chatescalationassignment.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatescalationassignment.event.ChatEscalationAssignmentRegisteredEvent;
import com.backintro.domain.chatescalationassignment.event.ChatEscalationAssignmentUpdatedEvent;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

public class ChatEscalationAssignment extends AggregateRoot {
    private final ChatEscalationAssignmentId id;
    private UUID escalationId;
    private UUID professionalId;
    private java.time.LocalDateTime assignedAt;

    private ChatEscalationAssignment(
        ChatEscalationAssignmentId id,
        UUID escalationId,
        UUID professionalId,
        java.time.LocalDateTime assignedAt) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.escalationId = Objects.requireNonNull(escalationId, "escalationId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.assignedAt = Objects.requireNonNull(assignedAt, "assignedAt must not be null");
    }

    public static ChatEscalationAssignment register(
        UUID escalationId,
        UUID professionalId,
        java.time.LocalDateTime assignedAt) {

        ChatEscalationAssignmentId id = ChatEscalationAssignmentId.generate();

        ChatEscalationAssignment entity = new ChatEscalationAssignment(
            id,
            escalationId,
            professionalId,
            assignedAt);

        entity.recordEvent(
            new ChatEscalationAssignmentRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ChatEscalationAssignment restore(
        ChatEscalationAssignmentId id,
        UUID escalationId,
        UUID professionalId,
        java.time.LocalDateTime assignedAt) {
        return new ChatEscalationAssignment(
            id,
            escalationId,
            professionalId,
            assignedAt);
    }

    public void update(
        UUID escalationId,
        UUID professionalId,
        java.time.LocalDateTime assignedAt) {

        this.escalationId = Objects.requireNonNull(escalationId);
        this.professionalId = Objects.requireNonNull(professionalId);
        this.assignedAt = Objects.requireNonNull(assignedAt);

        recordEvent(
            new ChatEscalationAssignmentUpdatedEvent(
                this.id,
                this.escalationId,
                this.professionalId,
                this.assignedAt,
                LocalDateTime.now()));
    }

    public ChatEscalationAssignmentId id() {
        return id;
    }

    public UUID escalationId() {
        return escalationId;
    }
    public UUID professionalId() {
        return professionalId;
    }
    public java.time.LocalDateTime assignedAt() {
        return assignedAt;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ChatEscalationAssignmentId getId() {
        return id();
    }

    public UUID getEscalationId() {
        return escalationId();
    }
    public UUID getProfessionalId() {
        return professionalId();
    }
    public java.time.LocalDateTime getAssignedAt() {
        return assignedAt();
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

    @Override
    public String toString() {
        return "ChatEscalationAssignment{" +
                "id=" + id +
                '}';
    }
}