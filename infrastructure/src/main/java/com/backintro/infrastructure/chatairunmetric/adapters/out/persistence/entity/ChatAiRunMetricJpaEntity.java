package com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat_ai_run_metrics")
public class ChatAiRunMetricJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "ai_run_id", nullable = false)
    private UUID aiRunId;
    @Column(name = "prompt_tokens", nullable = true)
    private Integer promptTokens;
    @Column(name = "completion_tokens", nullable = true)
    private Integer completionTokens;
    @Column(name = "total_tokens", nullable = true)
    private Integer totalTokens;
    @Column(name = "cost", nullable = true)
    private java.math.BigDecimal cost;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    public ChatAiRunMetricJpaEntity() {}

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) this.createdAt = LocalDateTime.now();
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

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
    public java.math.BigDecimal getCost() {
        return cost;
    }
    public void setCost(java.math.BigDecimal cost) {
        this.cost = cost;
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunMetricJpaEntity that = (ChatAiRunMetricJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}