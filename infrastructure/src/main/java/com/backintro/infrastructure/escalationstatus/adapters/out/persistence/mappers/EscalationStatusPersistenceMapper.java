package com.backintro.infrastructure.escalationstatus.adapters.out.persistence.mappers;

import com.backintro.domain.escalationstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.backintro.infrastructure.escalationstatus.adapters.out.persistence.entity.EscalationStatusJpaEntity;

public class EscalationStatusPersistenceMapper {

    public EscalationStatusJpaEntity toJpa(EscalationStatus domain) {
        if (domain == null) return null;
        EscalationStatusJpaEntity jpa = new EscalationStatusJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setNameStatus(domain.nameStatus());
        return jpa;
    }

    public EscalationStatus toDomain(EscalationStatusJpaEntity jpa) {
        if (jpa == null) return null;
        return EscalationStatus.restore(
                new EscalationStatusId(jpa.getId()),
                jpa.getNameStatus()
        );
    }
}