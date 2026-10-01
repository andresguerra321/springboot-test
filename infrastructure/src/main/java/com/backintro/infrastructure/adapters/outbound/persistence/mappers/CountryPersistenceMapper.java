package com.backintro.infrastructure.adapters.outbound.persistence.mappers;

import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryCode;
import com.backintro.infrastructure.adapters.outbound.persistence.entities.CountryJpaEntity;

/**
 * Mapper manual para convertir entre el modelo de Dominio (Country) y la entidad JPA (CountryJpaEntity).
 * Se implementa de forma pura sin librerías externas (sin MapStruct, sin Lombok).
 */
public class CountryPersistenceMapper {

    /**
     * Convierte una entidad JPA a modelo de Dominio.
     *
     * @param entity Entidad JPA.
     * @return Modelo de negocio Country, o null si entity es null.
     */
    public Country toDomain(CountryJpaEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Country(
                entity.getId(),
                entity.getNameCountry(),
                entity.getCodeCountry() != null ? new CountryCode(entity.getCodeCountry()) : null,
                entity.getDescription(),
                entity.getIsActive(),
                entity.getTelephonePrefix(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    /**
     * Convierte un modelo de Dominio a entidad JPA.
     *
     * @param domain Modelo de negocio Country.
     * @return Entidad JPA CountryJpaEntity, o null si domain es null.
     */
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
