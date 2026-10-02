package com.backintro.domain.chat.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ChatEscalation {

    private UUID id;
    private UUID conversationId;
    private UUID statusId;
    private Boolean fromAi;
    private String reason;
    private LocalDateTime createdAt;

    public ChatEscalation() {
    }

    public ChatEscalation(UUID id, UUID conversationId, UUID statusId, Boolean fromAi, String reason, LocalDateTime createdAt) {
        this.id = id;
        this.conversationId = conversationId;
        this.statusId = statusId;
        this.fromAi = fromAi != null ? fromAi : Boolean.FALSE;
        this.reason = reason;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

    public static ChatEscalation create(UUID conversationId, UUID statusId, Boolean fromAi, String reason) {
        return new ChatEscalation(UUID.randomUUID(), conversationId, statusId, fromAi, reason, LocalDateTime.now());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getConversationId() {
        return conversationId;
    }

    public void setConversationId(UUID conversationId) {
        this.conversationId = conversationId;
    }

    public UUID getStatusId() {
        return statusId;
    }

    public void setStatusId(UUID statusId) {
        this.statusId = statusId;
    }

    public Boolean getFromAi() {
        return fromAi;
    }

    public void setFromAi(Boolean fromAi) {
        this.fromAi = fromAi;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
}
