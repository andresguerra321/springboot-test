package com.backintro.infrastructure.consenttype.adapters.out.persistence.mappers;

import com.backintro.domain.consenttype.model.aggregate.ConsentType;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;
import com.backintro.infrastructure.consenttype.adapters.out.persistence.entity.ConsentTypeJpaEntity;

public class ConsentTypePersistenceMapper {

    public ConsentTypeJpaEntity toJpa(ConsentType domain) {

        if (domain == null) {
            return null;
        }

        ConsentTypeJpaEntity jpa = new ConsentTypeJpaEntity();

        jpa.setId(domain.id().value());
        jpa.setCode(domain.code());
        jpa.setName(domain.name());
        jpa.setActive(domain.active());
        jpa.setDescription(domain.description());

        return jpa;
    }

    public ConsentType toDomain(ConsentTypeJpaEntity jpa) {

        if (jpa == null) {
            return null;
        }

        return ConsentType.restore(
                new ConsentTypeId(jpa.getId()),
                jpa.getCode(),
                jpa.getName(),
                jpa.isActive(),
                jpa.getDescription()
        );
    }
}