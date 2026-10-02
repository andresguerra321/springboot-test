package com.backintro.infrastructure.stateregion.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.stateregion.model.aggregate.StateRegion;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.entity.StateRegionJpaEntity;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.mappers.StateRegionPersistenceMapper;

public class StateRegionRepositoryAdapter implements StateRegionRepository {
    private final StateRegionJpaRepository jpaRepository;
    private final StateRegionPersistenceMapper mapper;

    public StateRegionRepositoryAdapter(StateRegionJpaRepository jpaRepository, StateRegionPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public StateRegion save(StateRegion entity) {
        StateRegionJpaEntity jpaEntity = mapper.toJpa(entity);
        StateRegionJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<StateRegion> findById(StateRegionId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<StateRegion> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return jpaRepository.existsByCode(code);
    }
    @Override
    public void delete(StateRegion entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}