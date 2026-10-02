package com.backintro.domain.chat.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ChatMessage {

    private UUID id;
    private UUID conversationId;
    private UUID messageTypeId;
    private UUID participantId;
    private String content;
    private String metadata;
    private LocalDateTime createdAt;

    public ChatMessage() {
    }

    public ChatMessage(UUID id, UUID conversationId, UUID messageTypeId, UUID participantId,
                       String content, String metadata, LocalDateTime createdAt) {
        this.id = id;
        this.conversationId = conversationId;
        this.messageTypeId = messageTypeId;
        this.participantId = participantId;
        this.content = content;
        this.metadata = metadata;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

    public static ChatMessage create(UUID conversationId, UUID messageTypeId, UUID participantId, String content, String metadata) {
        return new ChatMessage(UUID.randomUUID(), conversationId, messageTypeId, participantId, content, metadata, LocalDateTime.now());
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

    public UUID getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(UUID messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    public UUID getParticipantId() {
        return participantId;
    }

    public void setParticipantId(UUID participantId) {
        this.participantId = participantId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
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
        ChatMessage that = (ChatMessage) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
