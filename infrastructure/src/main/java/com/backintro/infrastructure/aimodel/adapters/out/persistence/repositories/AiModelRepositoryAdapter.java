package com.backintro.infrastructure.aimodel.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.aimodel.model.aggregate.AiModel;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;
import com.backintro.infrastructure.aimodel.adapters.out.persistence.entity.AiModelJpaEntity;
import com.backintro.infrastructure.aimodel.adapters.out.persistence.mappers.AiModelPersistenceMapper;

public class AiModelRepositoryAdapter implements AiModelRepository {
    private final AiModelJpaRepository jpaRepository;
    private final AiModelPersistenceMapper mapper;

    public AiModelRepositoryAdapter(AiModelJpaRepository jpaRepository, AiModelPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public AiModel save(AiModel entity) {
        AiModelJpaEntity jpaEntity = mapper.toJpa(entity);
        AiModelJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<AiModel> findById(AiModelId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<AiModel> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(AiModel entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}