package com.backintro.infrastructure.risklevel.adapters.out.persistence.mappers;

import com.backintro.domain.risklevel.model.aggregate.RiskLevel;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;
import com.backintro.infrastructure.risklevel.adapters.out.persistence.entity.RiskLevelJpaEntity;

public class RiskLevelPersistenceMapper {

    public RiskLevelJpaEntity toJpa(RiskLevel domain) {

        if (domain == null) {
            return null;
        }

        RiskLevelJpaEntity jpa = new RiskLevelJpaEntity();

        jpa.setId(domain.id().value());
        jpa.setCode(domain.code());
        jpa.setName(domain.name());
        jpa.setActive(domain.active());
        jpa.setSeverity(domain.severity());

        return jpa;
    }

    public RiskLevel toDomain(RiskLevelJpaEntity jpa) {

        if (jpa == null) {
            return null;
        }

        return RiskLevel.restore(
                new RiskLevelId(jpa.getId()),
                jpa.getCode(),
                jpa.getName(),
                jpa.isActive(),
                jpa.getSeverity()
        );
    }
}