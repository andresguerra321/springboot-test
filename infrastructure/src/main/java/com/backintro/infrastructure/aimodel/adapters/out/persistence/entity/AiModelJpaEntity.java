package com.backintro.infrastructure.aimodel.adapters.out.persistence.entity;

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
@Table(name = "ai_models")
public class AiModelJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "provider_model_id", nullable = false)
    private UUID providerModelId;
    @Column(name = "name_model", nullable = false, length = 100)
    private String nameModel;
    @Column(name = "model_key", nullable = false, length = 120)
    private String modelKey;
    @Column(name = "input_token_price", nullable = true)
    private java.math.BigDecimal inputTokenPrice;
    @Column(name = "output_token_price", nullable = true)
    private java.math.BigDecimal outputTokenPrice;
    @Column(name = "max_tokens", nullable = true)
    private Integer maxTokens;
    @Column(name = "context_window", nullable = true)
    private Integer contextWindow;
    @Column(name = "is_active", nullable = false)
    private boolean active;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public AiModelJpaEntity() {}

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) this.createdAt = LocalDateTime.now();
        if (this.updatedAt == null) this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getProviderModelId() {
        return providerModelId;
    }
    public void setProviderModelId(UUID providerModelId) {
        this.providerModelId = providerModelId;
    }
    public String getNameModel() {
        return nameModel;
    }
    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }
    public String getModelKey() {
        return modelKey;
    }
    public void setModelKey(String modelKey) {
        this.modelKey = modelKey;
    }
    public java.math.BigDecimal getInputTokenPrice() {
        return inputTokenPrice;
    }
    public void setInputTokenPrice(java.math.BigDecimal inputTokenPrice) {
        this.inputTokenPrice = inputTokenPrice;
    }
    public java.math.BigDecimal getOutputTokenPrice() {
        return outputTokenPrice;
    }
    public void setOutputTokenPrice(java.math.BigDecimal outputTokenPrice) {
        this.outputTokenPrice = outputTokenPrice;
    }
    public Integer getMaxTokens() {
        return maxTokens;
    }
    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }
    public Integer getContextWindow() {
        return contextWindow;
    }
    public void setContextWindow(Integer contextWindow) {
        this.contextWindow = contextWindow;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AiModelJpaEntity that = (AiModelJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}