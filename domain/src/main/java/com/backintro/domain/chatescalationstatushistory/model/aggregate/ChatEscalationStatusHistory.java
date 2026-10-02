package com.backintro.domain.chatescalationstatushistory.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatescalationstatushistory.event.ChatEscalationStatusHistoryRegisteredEvent;
import com.backintro.domain.chatescalationstatushistory.event.ChatEscalationStatusHistoryUpdatedEvent;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

public class ChatEscalationStatusHistory extends AggregateRoot {
    private final ChatEscalationStatusHistoryId id;
    private UUID escalationId;
    private UUID escalationStatusId;
    private java.time.LocalDateTime changedAt;

    private ChatEscalationStatusHistory(
        ChatEscalationStatusHistoryId id,
        UUID escalationId,
        UUID escalationStatusId,
        java.time.LocalDateTime changedAt) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.escalationId = Objects.requireNonNull(escalationId, "escalationId must not be null");
        this.escalationStatusId = Objects.requireNonNull(escalationStatusId, "escalationStatusId must not be null");
        this.changedAt = Objects.requireNonNull(changedAt, "changedAt must not be null");
    }

    public static ChatEscalationStatusHistory register(
        UUID escalationId,
        UUID escalationStatusId,
        java.time.LocalDateTime changedAt) {

        ChatEscalationStatusHistoryId id = ChatEscalationStatusHistoryId.generate();

        ChatEscalationStatusHistory entity = new ChatEscalationStatusHistory(
            id,
            escalationId,
            escalationStatusId,
            changedAt);

        entity.recordEvent(
            new ChatEscalationStatusHistoryRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ChatEscalationStatusHistory restore(
        ChatEscalationStatusHistoryId id,
        UUID escalationId,
        UUID escalationStatusId,
        java.time.LocalDateTime changedAt) {
        return new ChatEscalationStatusHistory(
            id,
            escalationId,
            escalationStatusId,
            changedAt);
    }

    public void update(
        UUID escalationId,
        UUID escalationStatusId,
        java.time.LocalDateTime changedAt) {

        this.escalationId = Objects.requireNonNull(escalationId);
        this.escalationStatusId = Objects.requireNonNull(escalationStatusId);
        this.changedAt = Objects.requireNonNull(changedAt);

        recordEvent(
            new ChatEscalationStatusHistoryUpdatedEvent(
                this.id,
                this.escalationId,
                this.escalationStatusId,
                this.changedAt,
                LocalDateTime.now()));
    }

    public ChatEscalationStatusHistoryId id() {
        return id;
    }

    public UUID escalationId() {
        return escalationId;
    }
    public UUID escalationStatusId() {
        return escalationStatusId;
    }
    public java.time.LocalDateTime changedAt() {
        return changedAt;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ChatEscalationStatusHistoryId getId() {
        return id();
    }

    public UUID getEscalationId() {
        return escalationId();
    }
    public UUID getEscalationStatusId() {
        return escalationStatusId();
    }
    public java.time.LocalDateTime getChangedAt() {
        return changedAt();
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

    @Override
    public String toString() {
        return "ChatEscalationStatusHistory{" +
                "id=" + id +
                '}';
    }
}