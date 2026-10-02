package com.backintro.domain.chatairun.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatairun.event.ChatAiRunRegisteredEvent;
import com.backintro.domain.chatairun.event.ChatAiRunUpdatedEvent;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;

public class ChatAiRun extends AggregateRoot {
    private final ChatAiRunId id;
    private UUID conversationId;
    private UUID messageId;
    private UUID modelId;
    private UUID aiRunStatusId;

    private ChatAiRun(
        ChatAiRunId id,
        UUID conversationId,
        UUID messageId,
        UUID modelId,
        UUID aiRunStatusId) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.messageId = Objects.requireNonNull(messageId, "messageId must not be null");
        this.modelId = Objects.requireNonNull(modelId, "modelId must not be null");
        this.aiRunStatusId = Objects.requireNonNull(aiRunStatusId, "aiRunStatusId must not be null");
    }

    public static ChatAiRun register(
        UUID conversationId,
        UUID messageId,
        UUID modelId,
        UUID aiRunStatusId) {

        ChatAiRunId id = ChatAiRunId.generate();

        ChatAiRun entity = new ChatAiRun(
            id,
            conversationId,
            messageId,
            modelId,
            aiRunStatusId);

        entity.recordEvent(
            new ChatAiRunRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ChatAiRun restore(
        ChatAiRunId id,
        UUID conversationId,
        UUID messageId,
        UUID modelId,
        UUID aiRunStatusId) {
        return new ChatAiRun(
            id,
            conversationId,
            messageId,
            modelId,
            aiRunStatusId);
    }

    public void update(
        UUID conversationId,
        UUID messageId,
        UUID modelId,
        UUID aiRunStatusId) {

        this.conversationId = Objects.requireNonNull(conversationId);
        this.messageId = Objects.requireNonNull(messageId);
        this.modelId = Objects.requireNonNull(modelId);
        this.aiRunStatusId = Objects.requireNonNull(aiRunStatusId);

        recordEvent(
            new ChatAiRunUpdatedEvent(
                this.id,
                this.conversationId,
                this.messageId,
                this.modelId,
                this.aiRunStatusId,
                LocalDateTime.now()));
    }

    public ChatAiRunId id() {
        return id;
    }

    public UUID conversationId() {
        return conversationId;
    }
    public UUID messageId() {
        return messageId;
    }
    public UUID modelId() {
        return modelId;
    }
    public UUID aiRunStatusId() {
        return aiRunStatusId;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ChatAiRunId getId() {
        return id();
    }

    public UUID getConversationId() {
        return conversationId();
    }
    public UUID getMessageId() {
        return messageId();
    }
    public UUID getModelId() {
        return modelId();
    }
    public UUID getAiRunStatusId() {
        return aiRunStatusId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRun that = (ChatAiRun) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ChatAiRun{" +
                "id=" + id +
                '}';
    }
}