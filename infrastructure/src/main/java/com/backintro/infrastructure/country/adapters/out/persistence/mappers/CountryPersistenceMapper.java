package com.backintro.infrastructure.country.adapters.out.persistence.mappers;

import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryCode;
import com.backintro.infrastructure.country.adapters.out.persistence.entity.CountryJpaEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre el agregado de dominio Country y la entidad JPA CountryJpaEntity.
 */
@Component
public class CountryPersistenceMapper {

    public Country toDomain(CountryJpaEntity entity) {
        if (entity == null) {
            return null;
        }

        CountryCode code = entity.getCodeCountry() != null ? new CountryCode(entity.getCodeCountry()) : null;

        return new Country(
                entity.getId(),
                entity.getNameCountry(),
                code,
                entity.getDescription(),
                entity.getIsActive(),
                entity.getTelephonePrefix(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public CountryJpaEntity toJpaEntity(Country domain) {
        if (domain == null) {
            return null;
        }

        String code = domain.getCodeCountry() != null ? domain.getCodeCountry().getValue() : null;

        return new CountryJpaEntity(
                domain.getId(),
                domain.getNameCountry(),
                code,
                domain.getDescription(),
                domain.getIsActive(),
                domain.getTelephonePrefix(),
                domain.getCreatedAt(),
                domain.getUpdatedAt()
        );
    }
}
