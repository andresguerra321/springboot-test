package com.backintro.infrastructure.gender.adapters.out.persistence.mappers;

import com.backintro.domain.gender.model.aggregate.Gender;
import com.backintro.domain.gender.model.valueobject.GenderId;
import com.backintro.infrastructure.gender.adapters.out.persistence.entity.GenderJpaEntity;

public class GenderPersistenceMapper {

    public GenderJpaEntity toJpa(Gender domain) {

        if (domain == null) {
            return null;
        }

        GenderJpaEntity jpa = new GenderJpaEntity();

        jpa.setId(domain.id().value());
        jpa.setDescription(domain.description());

        return jpa;
    }

    public Gender toDomain(GenderJpaEntity jpa) {

        if (jpa == null) {
            return null;
        }

        return Gender.restore(
                new GenderId(jpa.getId()),
                jpa.getDescription()
        );
    }
}