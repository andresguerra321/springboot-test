package com.backintro.infrastructure.airunstatus.adapters.out.persistence.mappers;

import com.backintro.domain.airunstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.backintro.infrastructure.airunstatus.adapters.out.persistence.entity.AiRunStatusJpaEntity;

public class AiRunStatusPersistenceMapper {

    public AiRunStatusJpaEntity toJpa(AiRunStatus domain) {
        if (domain == null) return null;
        AiRunStatusJpaEntity jpa = new AiRunStatusJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setNameStatus(domain.nameStatus());
        return jpa;
    }

    public AiRunStatus toDomain(AiRunStatusJpaEntity jpa) {
        if (jpa == null) return null;
        return AiRunStatus.restore(
                new AiRunStatusId(jpa.getId()),
                jpa.getNameStatus()
        );
    }
}