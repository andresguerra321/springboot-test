package com.backintro.domain.chatescalation.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatescalation.event.ChatEscalationRegisteredEvent;
import com.backintro.domain.chatescalation.event.ChatEscalationUpdatedEvent;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;

public class ChatEscalation extends AggregateRoot {
    private final ChatEscalationId id;
    private UUID conversationId;
    private UUID statusId;
    private boolean fromAi;
    private String reason;

    private ChatEscalation(
        ChatEscalationId id,
        UUID conversationId,
        UUID statusId,
        boolean fromAi,
        String reason) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.statusId = Objects.requireNonNull(statusId, "statusId must not be null");
        this.fromAi = fromAi;
        this.reason = reason;
    }

    public static ChatEscalation register(
        UUID conversationId,
        UUID statusId,
        boolean fromAi,
        String reason) {

        ChatEscalationId id = ChatEscalationId.generate();

        ChatEscalation entity = new ChatEscalation(
            id,
            conversationId,
            statusId,
            fromAi,
            reason);

        entity.recordEvent(
            new ChatEscalationRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ChatEscalation restore(
        ChatEscalationId id,
        UUID conversationId,
        UUID statusId,
        boolean fromAi,
        String reason) {
        return new ChatEscalation(
            id,
            conversationId,
            statusId,
            fromAi,
            reason);
    }

    public void update(
        UUID conversationId,
        UUID statusId,
        boolean fromAi,
        String reason) {

        this.conversationId = Objects.requireNonNull(conversationId);
        this.statusId = Objects.requireNonNull(statusId);
        this.fromAi = fromAi;
        this.reason = reason;

        recordEvent(
            new ChatEscalationUpdatedEvent(
                this.id,
                this.conversationId,
                this.statusId,
                this.fromAi,
                this.reason,
                LocalDateTime.now()));
    }

    public ChatEscalationId id() {
        return id;
    }

    public UUID conversationId() {
        return conversationId;
    }
    public UUID statusId() {
        return statusId;
    }
    public boolean fromAi() {
        return fromAi;
    }
    public String reason() {
        return reason;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ChatEscalationId getId() {
        return id();
    }

    public UUID getConversationId() {
        return conversationId();
    }
    public UUID getStatusId() {
        return statusId();
    }
    public boolean isFromAi() {
        return fromAi();
    }
    public String getReason() {
        return reason();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalation that = (ChatEscalation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ChatEscalation{" +
                "id=" + id +
                '}';
    }
}