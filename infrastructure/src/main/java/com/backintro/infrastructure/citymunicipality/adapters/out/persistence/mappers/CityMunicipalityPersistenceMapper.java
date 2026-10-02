package com.backintro.infrastructure.citymunicipality.adapters.out.persistence.mappers;

import com.backintro.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.backintro.infrastructure.citymunicipality.adapters.out.persistence.entity.CityMunicipalityJpaEntity;

public class CityMunicipalityPersistenceMapper {

    public CityMunicipalityJpaEntity toJpa(CityMunicipality domain) {
        if (domain == null) return null;
        CityMunicipalityJpaEntity jpa = new CityMunicipalityJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setCode(domain.code());
        jpa.setName(domain.name());
        jpa.setDescription(domain.description());
        jpa.setActive(domain.active());
        jpa.setRegionId(domain.regionId());
        return jpa;
    }

    public CityMunicipality toDomain(CityMunicipalityJpaEntity jpa) {
        if (jpa == null) return null;
        return CityMunicipality.restore(
                new CityMunicipalityId(jpa.getId()),
                jpa.getCode(),
                jpa.getName(),
                jpa.getDescription(),
                jpa.isActive(),
                jpa.getRegionId()
        );
    }
}