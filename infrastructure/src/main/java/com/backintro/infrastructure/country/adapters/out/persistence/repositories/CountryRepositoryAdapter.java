package com.backintro.infrastructure.country.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.domain.country.port.repository.CountryRepository;
import com.backintro.infrastructure.country.adapters.out.persistence.entity.CountryJpaEntity;
import com.backintro.infrastructure.country.adapters.out.persistence.mappers.CountryPersistenceMapper;

public class CountryRepositoryAdapter implements CountryRepository {
    private final CountryJpaRepository jpaRepository;
    private final CountryPersistenceMapper mapper;

    public CountryRepositoryAdapter(CountryJpaRepository jpaRepository, CountryPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Country save(Country entity) {
        CountryJpaEntity jpaEntity = mapper.toJpa(entity);
        CountryJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Country> findById(CountryId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Country> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return jpaRepository.existsByCode(code);
    }
    @Override
    public void delete(Country entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}