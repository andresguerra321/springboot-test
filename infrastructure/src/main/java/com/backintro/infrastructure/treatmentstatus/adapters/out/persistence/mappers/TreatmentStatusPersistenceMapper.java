package com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.mappers;

import com.backintro.domain.treatmentstatus.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.entity.TreatmentStatusJpaEntity;

public class TreatmentStatusPersistenceMapper {

    public TreatmentStatusJpaEntity toJpa(TreatmentStatus domain) {

        if (domain == null) {
            return null;
        }

        TreatmentStatusJpaEntity jpa = new TreatmentStatusJpaEntity();

        jpa.setId(domain.id().value());
        jpa.setCode(domain.code());
        jpa.setName(domain.name());
        jpa.setActive(domain.active());
        jpa.setDescription(domain.description());

        return jpa;
    }

    public TreatmentStatus toDomain(TreatmentStatusJpaEntity jpa) {

        if (jpa == null) {
            return null;
        }

        return TreatmentStatus.restore(
                new TreatmentStatusId(jpa.getId()),
                jpa.getCode(),
                jpa.getName(),
                jpa.isActive(),
                jpa.getDescription()
        );
    }
}