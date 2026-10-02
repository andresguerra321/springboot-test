package com.backintro.infrastructure.conversationstatus.adapters.out.persistence.mappers;

import com.backintro.domain.conversationstatus.model.aggregate.ConversationStatus;
import com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.backintro.infrastructure.conversationstatus.adapters.out.persistence.entity.ConversationStatusJpaEntity;

public class ConversationStatusPersistenceMapper {

    public ConversationStatusJpaEntity toJpa(ConversationStatus domain) {
        if (domain == null) return null;
        ConversationStatusJpaEntity jpa = new ConversationStatusJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setNameStatus(domain.nameStatus());
        return jpa;
    }

    public ConversationStatus toDomain(ConversationStatusJpaEntity jpa) {
        if (jpa == null) return null;
        return ConversationStatus.restore(
                new ConversationStatusId(jpa.getId()),
                jpa.getNameStatus()
        );
    }
}