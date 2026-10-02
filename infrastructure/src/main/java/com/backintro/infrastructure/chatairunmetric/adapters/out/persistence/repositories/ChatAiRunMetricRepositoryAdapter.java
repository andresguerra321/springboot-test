package com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.backintro.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;
import com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.entity.ChatAiRunMetricJpaEntity;
import com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.mappers.ChatAiRunMetricPersistenceMapper;

public class ChatAiRunMetricRepositoryAdapter implements ChatAiRunMetricRepository {
    private final ChatAiRunMetricJpaRepository jpaRepository;
    private final ChatAiRunMetricPersistenceMapper mapper;

    public ChatAiRunMetricRepositoryAdapter(ChatAiRunMetricJpaRepository jpaRepository, ChatAiRunMetricPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatAiRunMetric save(ChatAiRunMetric entity) {
        ChatAiRunMetricJpaEntity jpaEntity = mapper.toJpa(entity);
        ChatAiRunMetricJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatAiRunMetric> findById(ChatAiRunMetricId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatAiRunMetric> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatAiRunMetric entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}