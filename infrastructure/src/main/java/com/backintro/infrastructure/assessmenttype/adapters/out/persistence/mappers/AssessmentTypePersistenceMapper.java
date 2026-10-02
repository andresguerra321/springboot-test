package com.backintro.infrastructure.assessmenttype.adapters.out.persistence.mappers;

import com.backintro.domain.assessmenttype.model.aggregate.AssessmentType;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;
import com.backintro.infrastructure.assessmenttype.adapters.out.persistence.entity.AssessmentTypeJpaEntity;

public class AssessmentTypePersistenceMapper {

    public AssessmentTypeJpaEntity toJpa(AssessmentType domain) {

        if (domain == null) {
            return null;
        }

        AssessmentTypeJpaEntity jpa = new AssessmentTypeJpaEntity();

        jpa.setId(domain.id().value());
        jpa.setCode(domain.code());
        jpa.setName(domain.name());
        jpa.setActive(domain.active());
        jpa.setDescription(domain.description());

        return jpa;
    }

    public AssessmentType toDomain(AssessmentTypeJpaEntity jpa) {

        if (jpa == null) {
            return null;
        }

        return AssessmentType.restore(
                new AssessmentTypeId(jpa.getId()),
                jpa.getCode(),
                jpa.getName(),
                jpa.isActive(),
                jpa.getDescription()
        );
    }
}