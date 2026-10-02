package com.backintro.infrastructure.providermodelai.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;
import com.backintro.infrastructure.providermodelai.adapters.out.persistence.entity.ProviderModelAiJpaEntity;
import com.backintro.infrastructure.providermodelai.adapters.out.persistence.mappers.ProviderModelAiPersistenceMapper;

public class ProviderModelAiRepositoryAdapter implements ProviderModelAiRepository {
    private final ProviderModelAiJpaRepository jpaRepository;
    private final ProviderModelAiPersistenceMapper mapper;

    public ProviderModelAiRepositoryAdapter(ProviderModelAiJpaRepository jpaRepository, ProviderModelAiPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ProviderModelAi save(ProviderModelAi entity) {
        ProviderModelAiJpaEntity jpaEntity = mapper.toJpa(entity);
        ProviderModelAiJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ProviderModelAi> findById(ProviderModelAiId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ProviderModelAi> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ProviderModelAi entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}