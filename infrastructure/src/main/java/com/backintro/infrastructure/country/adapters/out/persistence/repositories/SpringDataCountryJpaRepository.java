package com.backintro.infrastructure.country.adapters.out.persistence.repositories;

import com.backintro.infrastructure.country.adapters.out.persistence.entity.CountryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repositorio Spring Data JPA para la entidad CountryJpaEntity.
 */
@Repository
public interface SpringDataCountryJpaRepository extends JpaRepository<CountryJpaEntity, UUID> {

    Optional<CountryJpaEntity> findByCodeCountry(String codeCountry);

    boolean existsByCodeCountry(String codeCountry);
}
