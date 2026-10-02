package com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.mappers;

import com.backintro.domain.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.entity.ChatAiRunMetricJpaEntity;

public class ChatAiRunMetricPersistenceMapper {

    public ChatAiRunMetricJpaEntity toJpa(ChatAiRunMetric domain) {
        if (domain == null) return null;
        ChatAiRunMetricJpaEntity jpa = new ChatAiRunMetricJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setAiRunId(domain.aiRunId());
        jpa.setPromptTokens(domain.promptTokens());
        jpa.setCompletionTokens(domain.completionTokens());
        jpa.setTotalTokens(domain.totalTokens());
        jpa.setCost(domain.cost());
        return jpa;
    }

    public ChatAiRunMetric toDomain(ChatAiRunMetricJpaEntity jpa) {
        if (jpa == null) return null;
        return ChatAiRunMetric.restore(
                new ChatAiRunMetricId(jpa.getId()),
                jpa.getAiRunId(),
                jpa.getPromptTokens(),
                jpa.getCompletionTokens(),
                jpa.getTotalTokens(),
                jpa.getCost()
        );
    }
}