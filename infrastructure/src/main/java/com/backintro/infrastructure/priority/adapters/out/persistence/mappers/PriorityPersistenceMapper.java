package com.backintro.infrastructure.priority.adapters.out.persistence.mappers;

import com.backintro.domain.priority.model.aggregate.Priority;
import com.backintro.domain.priority.model.valueobject.PriorityId;
import com.backintro.infrastructure.priority.adapters.out.persistence.entity.PriorityJpaEntity;

public class PriorityPersistenceMapper {

    public PriorityJpaEntity toJpa(Priority domain) {
        if (domain == null) return null;
        PriorityJpaEntity jpa = new PriorityJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setNamePriority(domain.namePriority());
        return jpa;
    }

    public Priority toDomain(PriorityJpaEntity jpa) {
        if (jpa == null) return null;
        return Priority.restore(
                new PriorityId(jpa.getId()),
                jpa.getNamePriority()
        );
    }
}