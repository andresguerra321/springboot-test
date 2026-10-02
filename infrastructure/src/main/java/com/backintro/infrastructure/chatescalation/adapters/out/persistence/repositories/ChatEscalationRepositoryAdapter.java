package com.backintro.infrastructure.chatescalation.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatescalation.model.aggregate.ChatEscalation;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.backintro.domain.chatescalation.port.repository.ChatEscalationRepository;
import com.backintro.infrastructure.chatescalation.adapters.out.persistence.entity.ChatEscalationJpaEntity;
import com.backintro.infrastructure.chatescalation.adapters.out.persistence.mappers.ChatEscalationPersistenceMapper;

public class ChatEscalationRepositoryAdapter implements ChatEscalationRepository {
    private final ChatEscalationJpaRepository jpaRepository;
    private final ChatEscalationPersistenceMapper mapper;

    public ChatEscalationRepositoryAdapter(ChatEscalationJpaRepository jpaRepository, ChatEscalationPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatEscalation save(ChatEscalation entity) {
        ChatEscalationJpaEntity jpaEntity = mapper.toJpa(entity);
        ChatEscalationJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatEscalation> findById(ChatEscalationId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatEscalation> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatEscalation entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}