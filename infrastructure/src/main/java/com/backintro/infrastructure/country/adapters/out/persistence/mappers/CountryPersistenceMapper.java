package com.backintro.infrastructure.country.adapters.out.persistence.mappers;

import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.infrastructure.country.adapters.out.persistence.entity.CountryJpaEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Mapper para convertir entre el agregado de dominio Country y la entidad JPA CountryJpaEntity.
 */
@Component
public class CountryPersistenceMapper {

    public Country toDomain(CountryJpaEntity entity) {
        if (entity == null) {
            return null;
        }

        return Country.reconstitute(
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
                domain.getId() != null ? domain.getId().value() : null,
                domain.getName(),
                domain.getCode(),
                null,
                domain.isActive(),
                null,
                now,
                now
        );
    }
}
