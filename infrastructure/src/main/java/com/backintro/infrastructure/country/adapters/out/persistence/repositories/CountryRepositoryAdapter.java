package com.backintro.infrastructure.country.adapters.out.persistence.repositories;

import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.domain.country.port.repository.CountryRepository;
import com.backintro.infrastructure.country.adapters.out.persistence.entity.CountryJpaEntity;
import com.backintro.infrastructure.country.adapters.out.persistence.mappers.CountryPersistenceMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Adaptador de persistencia que implementa el puerto CountryRepository
 * delegando en SpringDataCountryJpaRepository y mapeando con CountryPersistenceMapper.
 */
@Component
public class CountryRepositoryAdapter implements CountryRepository {

    private final SpringDataCountryJpaRepository springDataRepository;
    private final CountryPersistenceMapper mapper;

    public CountryRepositoryAdapter(SpringDataCountryJpaRepository springDataRepository,
                                  CountryPersistenceMapper mapper) {
        this.springDataRepository = Objects.requireNonNull(springDataRepository, "SpringDataRepository no puede ser nulo");
        this.mapper = Objects.requireNonNull(mapper, "CountryPersistenceMapper no puede ser nulo");
    }

    @Override
    public Country save(Country country) {
        if (country == null) {
            throw new IllegalArgumentException("El país no puede ser nulo");
        }
        CountryJpaEntity jpaEntity = mapper.toJpaEntity(country);
        CountryJpaEntity savedEntity = springDataRepository.save(jpaEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Country> findById(CountryId id) {
        if (id == null || id.value() == null) {
            return Optional.empty();
        }
        return springDataRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Country> findAll() {
        List<CountryJpaEntity> entities = springDataRepository.findAll();
        List<Country> domainList = new ArrayList<>(entities.size());
        for (CountryJpaEntity entity : entities) {
            domainList.add(mapper.toDomain(entity));
        }
        return domainList;
    }

    @Override
    public boolean existsByCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return false;
        }
        return springDataRepository.existsByCodeCountry(code.trim());
    }

    @Override
    public void delete(Country country) {
        if (country != null && country.id() != null && country.id().value() != null) {
            springDataRepository.deleteById(country.id().value());
        }
    }
}
