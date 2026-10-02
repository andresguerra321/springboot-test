package com.backintro.infrastructure.encountermodality.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.encountermodality.model.aggregate.EncounterModality;
import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;
import com.backintro.infrastructure.encountermodality.adapters.out.persistence.entity.EncounterModalityJpaEntity;
import com.backintro.infrastructure.encountermodality.adapters.out.persistence.mappers.EncounterModalityPersistenceMapper;

public class EncounterModalityRepositoryAdapter implements EncounterModalityRepository {

    private final EncounterModalityJpaRepository jpaRepository;
    private final EncounterModalityPersistenceMapper mapper;

    public EncounterModalityRepositoryAdapter(
            EncounterModalityJpaRepository jpaRepository,
            EncounterModalityPersistenceMapper mapper
    ) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public EncounterModality save(EncounterModality entity) {
        EncounterModalityJpaEntity jpaEntity = mapper.toJpa(entity);
        EncounterModalityJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EncounterModality> findById(EncounterModalityId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<EncounterModality> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return jpaRepository.existsByCode(code);
    }
    @Override
    public void delete(EncounterModality entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}