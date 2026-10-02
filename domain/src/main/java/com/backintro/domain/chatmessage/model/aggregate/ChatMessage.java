package com.backintro.domain.chatmessage.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatmessage.event.ChatMessageRegisteredEvent;
import com.backintro.domain.chatmessage.event.ChatMessageUpdatedEvent;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;

public class ChatMessage extends AggregateRoot {
    private final ChatMessageId id;
    private UUID conversationId;
    private UUID messageTypeId;
    private UUID participantId;
    private String content;
    private String metadata;

    private ChatMessage(
        ChatMessageId id,
        UUID conversationId,
        UUID messageTypeId,
        UUID participantId,
        String content,
        String metadata) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.messageTypeId = Objects.requireNonNull(messageTypeId, "messageTypeId must not be null");
        this.participantId = Objects.requireNonNull(participantId, "participantId must not be null");
        this.content = content;
        this.metadata = metadata;
    }

    public static ChatMessage register(
        UUID conversationId,
        UUID messageTypeId,
        UUID participantId,
        String content,
        String metadata) {

        ChatMessageId id = ChatMessageId.generate();

        ChatMessage entity = new ChatMessage(
            id,
            conversationId,
            messageTypeId,
            participantId,
            content,
            metadata);

        entity.recordEvent(
            new ChatMessageRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ChatMessage restore(
        ChatMessageId id,
        UUID conversationId,
        UUID messageTypeId,
        UUID participantId,
        String content,
        String metadata) {
        return new ChatMessage(
            id,
            conversationId,
            messageTypeId,
            participantId,
            content,
            metadata);
    }

    public void update(
        UUID conversationId,
        UUID messageTypeId,
        UUID participantId,
        String content,
        String metadata) {

        this.conversationId = Objects.requireNonNull(conversationId);
        this.messageTypeId = Objects.requireNonNull(messageTypeId);
        this.participantId = Objects.requireNonNull(participantId);
        this.content = content;
        this.metadata = metadata;

        recordEvent(
            new ChatMessageUpdatedEvent(
                this.id,
                this.conversationId,
                this.messageTypeId,
                this.participantId,
                this.content,
                this.metadata,
                LocalDateTime.now()));
    }

    public ChatMessageId id() {
        return id;
    }

    public UUID conversationId() {
        return conversationId;
    }
    public UUID messageTypeId() {
        return messageTypeId;
    }
    public UUID participantId() {
        return participantId;
    }
    public String content() {
        return content;
    }
    public String metadata() {
        return metadata;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ChatMessageId getId() {
        return id();
    }

    public UUID getConversationId() {
        return conversationId();
    }
    public UUID getMessageTypeId() {
        return messageTypeId();
    }
    public UUID getParticipantId() {
        return participantId();
    }
    public String getContent() {
        return content();
    }
    public String getMetadata() {
        return metadata();
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

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                '}';
    }
}