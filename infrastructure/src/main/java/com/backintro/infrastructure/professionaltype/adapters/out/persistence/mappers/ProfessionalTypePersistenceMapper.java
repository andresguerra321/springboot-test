package com.backintro.infrastructure.professionaltype.adapters.out.persistence.mappers;

import com.backintro.domain.professionaltype.model.aggregate.ProfessionalType;
import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.backintro.infrastructure.professionaltype.adapters.out.persistence.entity.ProfessionalTypeJpaEntity;

public class ProfessionalTypePersistenceMapper {

    public ProfessionalTypeJpaEntity toJpa(ProfessionalType domain) {

        if (domain == null) {
            return null;
        }

        ProfessionalTypeJpaEntity jpa = new ProfessionalTypeJpaEntity();

        jpa.setId(domain.id().value());
        jpa.setName(domain.name());

        return jpa;
    }

    public ProfessionalType toDomain(ProfessionalTypeJpaEntity jpa) {

        if (jpa == null) {
            return null;
        }

        return ProfessionalType.restore(
                new ProfessionalTypeId(jpa.getId()),
                jpa.getName()
        );
    }
}