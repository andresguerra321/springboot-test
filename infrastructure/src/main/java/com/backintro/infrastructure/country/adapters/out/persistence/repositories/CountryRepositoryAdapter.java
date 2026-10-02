package com.backintro.infrastructure.country.adapters.out.persistence.repositories;

import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryCode;
import com.backintro.domain.country.port.repository.CountryRepository;
import com.backintro.infrastructure.country.adapters.out.persistence.entity.CountryJpaEntity;
import com.backintro.infrastructure.country.adapters.out.persistence.mappers.CountryPersistenceMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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
    public Optional<Country> findById(UUID id) {
        if (id == null) {
            return Optional.empty();
        }
        return springDataRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Country> findByCode(CountryCode codeCountry) {
        if (codeCountry == null || codeCountry.getValue() == null) {
            return Optional.empty();
        }
        return springDataRepository.findByCodeCountry(codeCountry.getValue()).map(mapper::toDomain);
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
    public void deleteById(UUID id) {
        if (id != null) {
            springDataRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        if (id == null) {
            return false;
        }
        return springDataRepository.existsById(id);
    }
}
