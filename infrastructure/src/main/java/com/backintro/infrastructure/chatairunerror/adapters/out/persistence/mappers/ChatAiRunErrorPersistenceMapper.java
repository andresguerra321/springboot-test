package com.backintro.infrastructure.chatairunerror.adapters.out.persistence.mappers;

import com.backintro.domain.chatairunerror.model.aggregate.ChatAiRunError;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.backintro.infrastructure.chatairunerror.adapters.out.persistence.entity.ChatAiRunErrorJpaEntity;

public class ChatAiRunErrorPersistenceMapper {

    public ChatAiRunErrorJpaEntity toJpa(ChatAiRunError domain) {
        if (domain == null) return null;
        ChatAiRunErrorJpaEntity jpa = new ChatAiRunErrorJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setAiRunId(domain.aiRunId());
        jpa.setErrorMessage(domain.errorMessage());
        jpa.setErrorCode(domain.errorCode());
        jpa.setProviderErrorId(domain.providerErrorId());
        return jpa;
    }

    public ChatAiRunError toDomain(ChatAiRunErrorJpaEntity jpa) {
        if (jpa == null) return null;
        return ChatAiRunError.restore(
                new ChatAiRunErrorId(jpa.getId()),
                jpa.getAiRunId(),
                jpa.getErrorMessage(),
                jpa.getErrorCode(),
                jpa.getProviderErrorId()
        );
    }
}