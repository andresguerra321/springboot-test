package com.backintro.domain.ai.model.aggregate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class AiModel {

    private UUID id;
    private UUID providerModelId;
    private String nameModel;
    private String modelKey;
    private BigDecimal inputTokenPrice;
    private BigDecimal outputTokenPrice;
    private Integer maxTokens;
    private Integer contextWindow;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AiModel() {
    }

    public AiModel(UUID id, UUID providerModelId, String nameModel, String modelKey,
                   BigDecimal inputTokenPrice, BigDecimal outputTokenPrice, Integer maxTokens,
                   Integer contextWindow, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.providerModelId = providerModelId;
        this.nameModel = nameModel;
        this.modelKey = modelKey;
        this.inputTokenPrice = inputTokenPrice;
        this.outputTokenPrice = outputTokenPrice;
        this.maxTokens = maxTokens;
        this.contextWindow = contextWindow;
        this.isActive = isActive != null ? isActive : Boolean.TRUE;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static AiModel create(UUID providerModelId, String nameModel, String modelKey,
                                BigDecimal inputTokenPrice, BigDecimal outputTokenPrice,
                                Integer maxTokens, Integer contextWindow) {
        LocalDateTime now = LocalDateTime.now();
        return new AiModel(
                UUID.randomUUID(),
                providerModelId,
                nameModel,
                modelKey,
                inputTokenPrice,
                outputTokenPrice,
                maxTokens,
                contextWindow,
                Boolean.TRUE,
                now,
                now
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public BigDecimal getInputTokenPrice() {
        return inputTokenPrice;
    }

    public void setInputTokenPrice(BigDecimal inputTokenPrice) {
        this.inputTokenPrice = inputTokenPrice;
    }

    public BigDecimal getOutputTokenPrice() {
        return outputTokenPrice;
    }

    public void setOutputTokenPrice(BigDecimal outputTokenPrice) {
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AiModel aiModel = (AiModel) o;
        return Objects.equals(id, aiModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
