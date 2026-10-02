package com.backintro.domain.chatconversation.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatconversation.event.ChatConversationRegisteredEvent;
import com.backintro.domain.chatconversation.event.ChatConversationUpdatedEvent;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;

public class ChatConversation extends AggregateRoot {
    private final ChatConversationId id;
    private UUID conversationStatusId;
    private UUID priorityId;
    private java.time.LocalDateTime lastMessageAt;
    private boolean closed;
    private java.time.LocalDateTime closedAt;
    private UUID closedBy;

    private ChatConversation(
        ChatConversationId id,
        UUID conversationStatusId,
        UUID priorityId,
        java.time.LocalDateTime lastMessageAt,
        boolean closed,
        java.time.LocalDateTime closedAt,
        UUID closedBy) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationStatusId = Objects.requireNonNull(conversationStatusId, "conversationStatusId must not be null");
        this.priorityId = Objects.requireNonNull(priorityId, "priorityId must not be null");
        this.lastMessageAt = lastMessageAt;
        this.closed = closed;
        this.closedAt = closedAt;
        this.closedBy = closedBy;
    }

    public static ChatConversation register(
        UUID conversationStatusId,
        UUID priorityId,
        java.time.LocalDateTime lastMessageAt,
        boolean closed,
        java.time.LocalDateTime closedAt,
        UUID closedBy) {

        ChatConversationId id = ChatConversationId.generate();

        ChatConversation entity = new ChatConversation(
            id,
            conversationStatusId,
            priorityId,
            lastMessageAt,
            closed,
            closedAt,
            closedBy);

        entity.recordEvent(
            new ChatConversationRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ChatConversation restore(
        ChatConversationId id,
        UUID conversationStatusId,
        UUID priorityId,
        java.time.LocalDateTime lastMessageAt,
        boolean closed,
        java.time.LocalDateTime closedAt,
        UUID closedBy) {
        return new ChatConversation(
            id,
            conversationStatusId,
            priorityId,
            lastMessageAt,
            closed,
            closedAt,
            closedBy);
    }

    public void update(
        UUID conversationStatusId,
        UUID priorityId,
        java.time.LocalDateTime lastMessageAt,
        boolean closed,
        java.time.LocalDateTime closedAt,
        UUID closedBy) {

        this.conversationStatusId = Objects.requireNonNull(conversationStatusId);
        this.priorityId = Objects.requireNonNull(priorityId);
        this.lastMessageAt = lastMessageAt;
        this.closed = closed;
        this.closedAt = closedAt;
        this.closedBy = closedBy;

        recordEvent(
            new ChatConversationUpdatedEvent(
                this.id,
                this.conversationStatusId,
                this.priorityId,
                this.lastMessageAt,
                this.closed,
                this.closedAt,
                this.closedBy,
                LocalDateTime.now()));
    }

    public ChatConversationId id() {
        return id;
    }

    public UUID conversationStatusId() {
        return conversationStatusId;
    }
    public UUID priorityId() {
        return priorityId;
    }
    public java.time.LocalDateTime lastMessageAt() {
        return lastMessageAt;
    }
    public boolean closed() {
        return closed;
    }
    public java.time.LocalDateTime closedAt() {
        return closedAt;
    }
    public UUID closedBy() {
        return closedBy;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ChatConversationId getId() {
        return id();
    }

    public UUID getConversationStatusId() {
        return conversationStatusId();
    }
    public UUID getPriorityId() {
        return priorityId();
    }
    public java.time.LocalDateTime getLastMessageAt() {
        return lastMessageAt();
    }
    public boolean isClosed() {
        return closed();
    }
    public java.time.LocalDateTime getClosedAt() {
        return closedAt();
    }
    public UUID getClosedBy() {
        return closedBy();
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

    @Override
    public String toString() {
        return "ChatConversation{" +
                "id=" + id +
                '}';
    }
}