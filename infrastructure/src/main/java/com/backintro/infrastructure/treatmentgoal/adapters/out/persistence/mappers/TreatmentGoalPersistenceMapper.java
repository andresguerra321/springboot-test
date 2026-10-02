package com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.mappers;

import com.backintro.domain.treatmentgoal.model.aggregate.TreatmentGoal;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.entity.TreatmentGoalJpaEntity;

public class TreatmentGoalPersistenceMapper {

    public TreatmentGoalJpaEntity toJpa(TreatmentGoal domain) {
        if (domain == null) return null;
        TreatmentGoalJpaEntity jpa = new TreatmentGoalJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setTreatmentPlanId(domain.treatmentPlanId());
        jpa.setDescription(domain.description());
        jpa.setTargetDate(domain.targetDate());
        jpa.setCompletedAt(domain.completedAt());
        jpa.setNotes(domain.notes());
        jpa.setTreatmentGoalStatusId(domain.treatmentGoalStatusId());
        return jpa;
    }

    public TreatmentGoal toDomain(TreatmentGoalJpaEntity jpa) {
        if (jpa == null) return null;
        return TreatmentGoal.restore(
                new TreatmentGoalId(jpa.getId()),
                jpa.getTreatmentPlanId(),
                jpa.getDescription(),
                jpa.getTargetDate(),
                jpa.getCompletedAt(),
                jpa.getNotes(),
                jpa.getTreatmentGoalStatusId()
        );
    }
}