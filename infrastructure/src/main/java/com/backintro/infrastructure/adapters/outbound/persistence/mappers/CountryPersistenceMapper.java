package com.backintro.infrastructure.adapters.outbound.persistence.mappers;

import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.infrastructure.adapters.outbound.persistence.entities.CountryJpaEntity;

import java.time.LocalDateTime;

/**
 * Mapper manual para convertir entre el modelo de Dominio (Country) y la entidad JPA (CountryJpaEntity).
 */
public class CountryPersistenceMapper {

    public Country toDomain(CountryJpaEntity entity) {
        if (entity == null) {
            return null;
        }

        return Country.restore(
                new CountryId(entity.getId()),
                entity.getNameCountry(),
                entity.getCodeCountry(),
                entity.getIsActive() != null ? entity.getIsActive() : true
        );
    }

    public CountryJpaEntity toJpaEntity(Country domain) {
        if (domain == null) {
            return null;
        }

        LocalDateTime now = LocalDateTime.now();

        return new CountryJpaEntity(
                domain.id() != null ? domain.id().value() : null,
                domain.name(),
                domain.code(),
                null,
                domain.isActive(),
                null,
                now,
                now
        );
    }
}
