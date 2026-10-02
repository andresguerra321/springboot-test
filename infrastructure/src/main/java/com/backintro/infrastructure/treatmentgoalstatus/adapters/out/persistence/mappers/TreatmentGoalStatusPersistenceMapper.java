package com.backintro.infrastructure.treatmentgoalstatus.adapters.out.persistence.mappers;

import com.backintro.domain.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;
import com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.backintro.infrastructure.treatmentgoalstatus.adapters.out.persistence.entity.TreatmentGoalStatusJpaEntity;

public class TreatmentGoalStatusPersistenceMapper {

    public TreatmentGoalStatusJpaEntity toJpa(TreatmentGoalStatus domain) {

        if (domain == null) {
            return null;
        }

        TreatmentGoalStatusJpaEntity jpa = new TreatmentGoalStatusJpaEntity();

        jpa.setId(domain.id().value());
        jpa.setCode(domain.code());
        jpa.setName(domain.name());
        jpa.setActive(domain.active());
        jpa.setDescription(domain.description());

        return jpa;
    }

    public TreatmentGoalStatus toDomain(TreatmentGoalStatusJpaEntity jpa) {

        if (jpa == null) {
            return null;
        }

        return TreatmentGoalStatus.restore(
                new TreatmentGoalStatusId(jpa.getId()),
                jpa.getCode(),
                jpa.getName(),
                jpa.isActive(),
                jpa.getDescription()
        );
    }
}