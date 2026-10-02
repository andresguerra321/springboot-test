package com.backintro.domain.ai.model.aggregate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ChatAiRunMetrics {

    private UUID id;
    private UUID aiRunId;
    private Integer promptTokens;
    private Integer completionTokens;
    private Integer totalTokens;
    private BigDecimal cost;
    private LocalDateTime createdAt;

    public ChatAiRunMetrics() {
    }

    public ChatAiRunMetrics(UUID id, UUID aiRunId, Integer promptTokens, Integer completionTokens,
                            Integer totalTokens, BigDecimal cost, LocalDateTime createdAt) {
        this.id = id;
        this.aiRunId = aiRunId;
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
        this.cost = cost;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

    public static ChatAiRunMetrics create(UUID aiRunId, Integer promptTokens, Integer completionTokens, BigDecimal cost) {
        int total = (promptTokens != null ? promptTokens : 0) + (completionTokens != null ? completionTokens : 0);
        return new ChatAiRunMetrics(UUID.randomUUID(), aiRunId, promptTokens, completionTokens, total, cost, LocalDateTime.now());
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

    public Integer getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(Integer promptTokens) {
        this.promptTokens = promptTokens;
    }

    public Integer getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(Integer completionTokens) {
        this.completionTokens = completionTokens;
    }

    public Integer getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(Integer totalTokens) {
        this.totalTokens = totalTokens;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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
        ChatAiRunMetrics that = (ChatAiRunMetrics) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
