package com.backintro.infrastructure.encounterstatus.adapters.out.persistence.mappers;

import com.backintro.domain.encounterstatus.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.backintro.infrastructure.encounterstatus.adapters.out.persistence.entity.EncounterStatusJpaEntity;

public class EncounterStatusPersistenceMapper {

    public EncounterStatusJpaEntity toJpa(EncounterStatus domain) {

        if (domain == null) {
            return null;
        }

        EncounterStatusJpaEntity jpa = new EncounterStatusJpaEntity();

        jpa.setId(domain.id().value());
        jpa.setCode(domain.code());
        jpa.setName(domain.name());
        jpa.setActive(domain.active());

        return jpa;
    }

    public EncounterStatus toDomain(EncounterStatusJpaEntity jpa) {

        if (jpa == null) {
            return null;
        }

        return EncounterStatus.restore(
                new EncounterStatusId(jpa.getId()),
                jpa.getCode(),
                jpa.getName(),
                jpa.isActive()
        );
    }
}