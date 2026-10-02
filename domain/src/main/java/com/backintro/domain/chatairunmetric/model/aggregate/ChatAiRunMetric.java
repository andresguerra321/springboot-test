package com.backintro.domain.chatairunmetric.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatairunmetric.event.ChatAiRunMetricRegisteredEvent;
import com.backintro.domain.chatairunmetric.event.ChatAiRunMetricUpdatedEvent;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

public class ChatAiRunMetric extends AggregateRoot {
    private final ChatAiRunMetricId id;
    private UUID aiRunId;
    private Integer promptTokens;
    private Integer completionTokens;
    private Integer totalTokens;
    private java.math.BigDecimal cost;

    private ChatAiRunMetric(
        ChatAiRunMetricId id,
        UUID aiRunId,
        Integer promptTokens,
        Integer completionTokens,
        Integer totalTokens,
        java.math.BigDecimal cost) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.aiRunId = Objects.requireNonNull(aiRunId, "aiRunId must not be null");
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
        this.cost = cost;
    }

    public static ChatAiRunMetric register(
        UUID aiRunId,
        Integer promptTokens,
        Integer completionTokens,
        Integer totalTokens,
        java.math.BigDecimal cost) {

        ChatAiRunMetricId id = ChatAiRunMetricId.generate();

        ChatAiRunMetric entity = new ChatAiRunMetric(
            id,
            aiRunId,
            promptTokens,
            completionTokens,
            totalTokens,
            cost);

        entity.recordEvent(
            new ChatAiRunMetricRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ChatAiRunMetric restore(
        ChatAiRunMetricId id,
        UUID aiRunId,
        Integer promptTokens,
        Integer completionTokens,
        Integer totalTokens,
        java.math.BigDecimal cost) {
        return new ChatAiRunMetric(
            id,
            aiRunId,
            promptTokens,
            completionTokens,
            totalTokens,
            cost);
    }

    public void update(
        UUID aiRunId,
        Integer promptTokens,
        Integer completionTokens,
        Integer totalTokens,
        java.math.BigDecimal cost) {

        this.aiRunId = Objects.requireNonNull(aiRunId);
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
        this.cost = cost;

        recordEvent(
            new ChatAiRunMetricUpdatedEvent(
                this.id,
                this.aiRunId,
                this.promptTokens,
                this.completionTokens,
                this.totalTokens,
                this.cost,
                LocalDateTime.now()));
    }

    public ChatAiRunMetricId id() {
        return id;
    }

    public UUID aiRunId() {
        return aiRunId;
    }
    public Integer promptTokens() {
        return promptTokens;
    }
    public Integer completionTokens() {
        return completionTokens;
    }
    public Integer totalTokens() {
        return totalTokens;
    }
    public java.math.BigDecimal cost() {
        return cost;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ChatAiRunMetricId getId() {
        return id();
    }

    public UUID getAiRunId() {
        return aiRunId();
    }
    public Integer getPromptTokens() {
        return promptTokens();
    }
    public Integer getCompletionTokens() {
        return completionTokens();
    }
    public Integer getTotalTokens() {
        return totalTokens();
    }
    public java.math.BigDecimal getCost() {
        return cost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunMetric that = (ChatAiRunMetric) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ChatAiRunMetric{" +
                "id=" + id +
                '}';
    }
}