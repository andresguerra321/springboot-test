package com.backintro.domain.chatairunerror.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatairunerror.event.ChatAiRunErrorRegisteredEvent;
import com.backintro.domain.chatairunerror.event.ChatAiRunErrorUpdatedEvent;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

public class ChatAiRunError extends AggregateRoot {
    private final ChatAiRunErrorId id;
    private UUID aiRunId;
    private String errorMessage;
    private String errorCode;
    private String providerErrorId;

    private ChatAiRunError(
        ChatAiRunErrorId id,
        UUID aiRunId,
        String errorMessage,
        String errorCode,
        String providerErrorId) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.aiRunId = Objects.requireNonNull(aiRunId, "aiRunId must not be null");
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.providerErrorId = providerErrorId;
    }

    public static ChatAiRunError register(
        UUID aiRunId,
        String errorMessage,
        String errorCode,
        String providerErrorId) {

        ChatAiRunErrorId id = ChatAiRunErrorId.generate();

        ChatAiRunError entity = new ChatAiRunError(
            id,
            aiRunId,
            errorMessage,
            errorCode,
            providerErrorId);

        entity.recordEvent(
            new ChatAiRunErrorRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ChatAiRunError restore(
        ChatAiRunErrorId id,
        UUID aiRunId,
        String errorMessage,
        String errorCode,
        String providerErrorId) {
        return new ChatAiRunError(
            id,
            aiRunId,
            errorMessage,
            errorCode,
            providerErrorId);
    }

    public void update(
        UUID aiRunId,
        String errorMessage,
        String errorCode,
        String providerErrorId) {

        this.aiRunId = Objects.requireNonNull(aiRunId);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.providerErrorId = providerErrorId;

        recordEvent(
            new ChatAiRunErrorUpdatedEvent(
                this.id,
                this.aiRunId,
                this.errorMessage,
                this.errorCode,
                this.providerErrorId,
                LocalDateTime.now()));
    }

    public ChatAiRunErrorId id() {
        return id;
    }

    public UUID aiRunId() {
        return aiRunId;
    }
    public String errorMessage() {
        return errorMessage;
    }
    public String errorCode() {
        return errorCode;
    }
    public String providerErrorId() {
        return providerErrorId;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ChatAiRunErrorId getId() {
        return id();
    }

    public UUID getAiRunId() {
        return aiRunId();
    }
    public String getErrorMessage() {
        return errorMessage();
    }
    public String getErrorCode() {
        return errorCode();
    }
    public String getProviderErrorId() {
        return providerErrorId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunError that = (ChatAiRunError) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ChatAiRunError{" +
                "id=" + id +
                '}';
    }
}