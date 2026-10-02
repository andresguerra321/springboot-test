package com.backintro.infrastructure.country.adapters.out.persistence.mappers;

import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.infrastructure.country.adapters.out.persistence.entity.CountryJpaEntity;

public class CountryPersistenceMapper {

    public CountryJpaEntity toJpa(Country domain) {
        if (domain == null) return null;
        CountryJpaEntity jpa = new CountryJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setCode(domain.code());
        jpa.setName(domain.name());
        jpa.setDescription(domain.description());
        jpa.setActive(domain.active());
        jpa.setTelephonePrefix(domain.telephonePrefix());
        return jpa;
    }

    public Country toDomain(CountryJpaEntity jpa) {
        if (jpa == null) return null;
        return Country.restore(
                new CountryId(jpa.getId()),
                jpa.getCode(),
                jpa.getName(),
                jpa.getDescription(),
                jpa.isActive(),
                jpa.getTelephonePrefix()
        );
    }
}