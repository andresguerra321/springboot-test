package com.backintro.infrastructure.stateregion.adapters.out.persistence.mappers;

import com.backintro.domain.stateregion.model.aggregate.StateRegion;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.entity.StateRegionJpaEntity;

public class StateRegionPersistenceMapper {

    public StateRegionJpaEntity toJpa(StateRegion domain) {
        if (domain == null) return null;
        StateRegionJpaEntity jpa = new StateRegionJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setCode(domain.code());
        jpa.setName(domain.name());
        jpa.setDescription(domain.description());
        jpa.setActive(domain.active());
        jpa.setCountryId(domain.countryId());
        return jpa;
    }

    public StateRegion toDomain(StateRegionJpaEntity jpa) {
        if (jpa == null) return null;
        return StateRegion.restore(
                new StateRegionId(jpa.getId()),
                jpa.getCode(),
                jpa.getName(),
                jpa.getDescription(),
                jpa.isActive(),
                jpa.getCountryId()
        );
    }
}