package com.backintro.infrastructure.airunstatus.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.airunstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;
import com.backintro.infrastructure.airunstatus.adapters.out.persistence.entity.AiRunStatusJpaEntity;
import com.backintro.infrastructure.airunstatus.adapters.out.persistence.mappers.AiRunStatusPersistenceMapper;

public class AiRunStatusRepositoryAdapter implements AiRunStatusRepository {
    private final AiRunStatusJpaRepository jpaRepository;
    private final AiRunStatusPersistenceMapper mapper;

    public AiRunStatusRepositoryAdapter(AiRunStatusJpaRepository jpaRepository, AiRunStatusPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public AiRunStatus save(AiRunStatus entity) {
        AiRunStatusJpaEntity jpaEntity = mapper.toJpa(entity);
        AiRunStatusJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<AiRunStatus> findById(AiRunStatusId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<AiRunStatus> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(AiRunStatus entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}