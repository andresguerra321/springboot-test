package com.backintro.infrastructure.priority.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.priority.model.aggregate.Priority;
import com.backintro.domain.priority.model.valueobject.PriorityId;
import com.backintro.domain.priority.port.repository.PriorityRepository;
import com.backintro.infrastructure.priority.adapters.out.persistence.entity.PriorityJpaEntity;
import com.backintro.infrastructure.priority.adapters.out.persistence.mappers.PriorityPersistenceMapper;

public class PriorityRepositoryAdapter implements PriorityRepository {
    private final PriorityJpaRepository jpaRepository;
    private final PriorityPersistenceMapper mapper;

    public PriorityRepositoryAdapter(PriorityJpaRepository jpaRepository, PriorityPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Priority save(Priority entity) {
        PriorityJpaEntity jpaEntity = mapper.toJpa(entity);
        PriorityJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Priority> findById(PriorityId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Priority> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Priority entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}