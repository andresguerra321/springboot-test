package com.backintro.infrastructure.chatairun.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatairun.model.aggregate.ChatAiRun;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;
import com.backintro.infrastructure.chatairun.adapters.out.persistence.entity.ChatAiRunJpaEntity;
import com.backintro.infrastructure.chatairun.adapters.out.persistence.mappers.ChatAiRunPersistenceMapper;

public class ChatAiRunRepositoryAdapter implements ChatAiRunRepository {
    private final ChatAiRunJpaRepository jpaRepository;
    private final ChatAiRunPersistenceMapper mapper;

    public ChatAiRunRepositoryAdapter(ChatAiRunJpaRepository jpaRepository, ChatAiRunPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatAiRun save(ChatAiRun entity) {
        ChatAiRunJpaEntity jpaEntity = mapper.toJpa(entity);
        ChatAiRunJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatAiRun> findById(ChatAiRunId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatAiRun> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatAiRun entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}