package com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.mappers;

import com.backintro.domain.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.entity.ChatEscalationStatusHistoryJpaEntity;

public class ChatEscalationStatusHistoryPersistenceMapper {

    public ChatEscalationStatusHistoryJpaEntity toJpa(ChatEscalationStatusHistory domain) {
        if (domain == null) return null;
        ChatEscalationStatusHistoryJpaEntity jpa = new ChatEscalationStatusHistoryJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setEscalationId(domain.escalationId());
        jpa.setEscalationStatusId(domain.escalationStatusId());
        jpa.setChangedAt(domain.changedAt());
        return jpa;
    }

    public ChatEscalationStatusHistory toDomain(ChatEscalationStatusHistoryJpaEntity jpa) {
        if (jpa == null) return null;
        return ChatEscalationStatusHistory.restore(
                new ChatEscalationStatusHistoryId(jpa.getId()),
                jpa.getEscalationId(),
                jpa.getEscalationStatusId(),
                jpa.getChangedAt()
        );
    }
}