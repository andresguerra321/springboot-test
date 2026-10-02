package com.backintro.infrastructure.encounter.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.encounter.model.aggregate.Encounter;
import com.backintro.domain.encounter.model.valueobject.EncounterId;
import com.backintro.domain.encounter.port.repository.EncounterRepository;
import com.backintro.infrastructure.encounter.adapters.out.persistence.entity.EncounterJpaEntity;
import com.backintro.infrastructure.encounter.adapters.out.persistence.mappers.EncounterPersistenceMapper;

public class EncounterRepositoryAdapter implements EncounterRepository {
    private final EncounterJpaRepository jpaRepository;
    private final EncounterPersistenceMapper mapper;

    public EncounterRepositoryAdapter(EncounterJpaRepository jpaRepository, EncounterPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Encounter save(Encounter entity) {
        EncounterJpaEntity jpaEntity = mapper.toJpa(entity);
        EncounterJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Encounter> findById(EncounterId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Encounter> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Encounter entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}