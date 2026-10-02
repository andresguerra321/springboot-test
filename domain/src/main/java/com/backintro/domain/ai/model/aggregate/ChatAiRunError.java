package com.backintro.domain.ai.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ChatAiRunError {

    private UUID id;
    private UUID aiRunId;
    private String errorMessage;
    private String errorCode;
    private String providerErrorId;
    private LocalDateTime createdAt;

    public ChatAiRunError() {
    }

    public ChatAiRunError(UUID id, UUID aiRunId, String errorMessage, String errorCode,
                          String providerErrorId, LocalDateTime createdAt) {
        this.id = id;
        this.aiRunId = aiRunId;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.providerErrorId = providerErrorId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

    public static ChatAiRunError create(UUID aiRunId, String errorMessage, String errorCode, String providerErrorId) {
        return new ChatAiRunError(UUID.randomUUID(), aiRunId, errorMessage, errorCode, providerErrorId, LocalDateTime.now());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAiRunId() {
        return aiRunId;
    }

    public void setAiRunId(UUID aiRunId) {
        this.aiRunId = aiRunId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getProviderErrorId() {
        return providerErrorId;
    }

    public void setProviderErrorId(String providerErrorId) {
        this.providerErrorId = providerErrorId;
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
        ChatAiRunError that = (ChatAiRunError) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
