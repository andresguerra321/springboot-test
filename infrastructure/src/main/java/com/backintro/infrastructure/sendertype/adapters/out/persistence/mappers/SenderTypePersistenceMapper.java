package com.backintro.infrastructure.sendertype.adapters.out.persistence.mappers;

import com.backintro.domain.sendertype.model.aggregate.SenderType;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;
import com.backintro.infrastructure.sendertype.adapters.out.persistence.entity.SenderTypeJpaEntity;

public class SenderTypePersistenceMapper {

    public SenderTypeJpaEntity toJpa(SenderType domain) {
        if (domain == null) return null;
        SenderTypeJpaEntity jpa = new SenderTypeJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setNameType(domain.nameType());
        return jpa;
    }

    public SenderType toDomain(SenderTypeJpaEntity jpa) {
        if (jpa == null) return null;
        return SenderType.restore(
                new SenderTypeId(jpa.getId()),
                jpa.getNameType()
        );
    }
}