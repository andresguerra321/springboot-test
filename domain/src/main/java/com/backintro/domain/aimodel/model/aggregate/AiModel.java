package com.backintro.domain.aimodel.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.aimodel.event.AiModelRegisteredEvent;
import com.backintro.domain.aimodel.event.AiModelUpdatedEvent;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;

public class AiModel extends AggregateRoot {
    private final AiModelId id;
    private UUID providerModelId;
    private String nameModel;
    private String modelKey;
    private java.math.BigDecimal inputTokenPrice;
    private java.math.BigDecimal outputTokenPrice;
    private Integer maxTokens;
    private Integer contextWindow;
    private boolean active;

    private AiModel(
        AiModelId id,
        UUID providerModelId,
        String nameModel,
        String modelKey,
        java.math.BigDecimal inputTokenPrice,
        java.math.BigDecimal outputTokenPrice,
        Integer maxTokens,
        Integer contextWindow,
        boolean active) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.providerModelId = Objects.requireNonNull(providerModelId, "providerModelId must not be null");
        this.nameModel = Objects.requireNonNull(nameModel, "nameModel must not be null");
        this.modelKey = Objects.requireNonNull(modelKey, "modelKey must not be null");
        this.inputTokenPrice = inputTokenPrice;
        this.outputTokenPrice = outputTokenPrice;
        this.maxTokens = maxTokens;
        this.contextWindow = contextWindow;
        this.active = active;
    }

    public static AiModel register(
        UUID providerModelId,
        String nameModel,
        String modelKey,
        java.math.BigDecimal inputTokenPrice,
        java.math.BigDecimal outputTokenPrice,
        Integer maxTokens,
        Integer contextWindow) {

        AiModelId id = AiModelId.generate();

        AiModel entity = new AiModel(
            id,
            providerModelId,
            nameModel,
            modelKey,
            inputTokenPrice,
            outputTokenPrice,
            maxTokens,
            contextWindow,
            true);

        entity.recordEvent(
            new AiModelRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static AiModel restore(
        AiModelId id,
        UUID providerModelId,
        String nameModel,
        String modelKey,
        java.math.BigDecimal inputTokenPrice,
        java.math.BigDecimal outputTokenPrice,
        Integer maxTokens,
        Integer contextWindow,
        boolean active) {
        return new AiModel(
            id,
            providerModelId,
            nameModel,
            modelKey,
            inputTokenPrice,
            outputTokenPrice,
            maxTokens,
            contextWindow,
            active);
    }

    public void update(
        UUID providerModelId,
        String nameModel,
        String modelKey,
        java.math.BigDecimal inputTokenPrice,
        java.math.BigDecimal outputTokenPrice,
        Integer maxTokens,
        Integer contextWindow) {

        this.providerModelId = Objects.requireNonNull(providerModelId);
        this.nameModel = Objects.requireNonNull(nameModel);
        this.modelKey = Objects.requireNonNull(modelKey);
        this.inputTokenPrice = inputTokenPrice;
        this.outputTokenPrice = outputTokenPrice;
        this.maxTokens = maxTokens;
        this.contextWindow = contextWindow;

        recordEvent(
            new AiModelUpdatedEvent(
                this.id,
                this.providerModelId,
                this.nameModel,
                this.modelKey,
                this.inputTokenPrice,
                this.outputTokenPrice,
                this.maxTokens,
                this.contextWindow,
                LocalDateTime.now()));
    }

    public AiModelId id() {
        return id;
    }

    public UUID providerModelId() {
        return providerModelId;
    }
    public String nameModel() {
        return nameModel;
    }
    public String modelKey() {
        return modelKey;
    }
    public java.math.BigDecimal inputTokenPrice() {
        return inputTokenPrice;
    }
    public java.math.BigDecimal outputTokenPrice() {
        return outputTokenPrice;
    }
    public Integer maxTokens() {
        return maxTokens;
    }
    public Integer contextWindow() {
        return contextWindow;
    }
    public boolean active() {
        return active;
    }
    // Alias para compatibilidad con mappers y frameworks
    public AiModelId getId() {
        return id();
    }

    public UUID getProviderModelId() {
        return providerModelId();
    }
    public String getNameModel() {
        return nameModel();
    }
    public String getModelKey() {
        return modelKey();
    }
    public java.math.BigDecimal getInputTokenPrice() {
        return inputTokenPrice();
    }
    public java.math.BigDecimal getOutputTokenPrice() {
        return outputTokenPrice();
    }
    public Integer getMaxTokens() {
        return maxTokens();
    }
    public Integer getContextWindow() {
        return contextWindow();
    }

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AiModel that = (AiModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AiModel{" +
                "id=" + id +
                '}';
    }
}