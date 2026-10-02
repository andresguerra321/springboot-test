package com.backintro.infrastructure.chatparticipant.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatparticipant.model.aggregate.ChatParticipant;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;
import com.backintro.infrastructure.chatparticipant.adapters.out.persistence.entity.ChatParticipantJpaEntity;
import com.backintro.infrastructure.chatparticipant.adapters.out.persistence.mappers.ChatParticipantPersistenceMapper;

public class ChatParticipantRepositoryAdapter implements ChatParticipantRepository {
    private final ChatParticipantJpaRepository jpaRepository;
    private final ChatParticipantPersistenceMapper mapper;

    public ChatParticipantRepositoryAdapter(ChatParticipantJpaRepository jpaRepository, ChatParticipantPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatParticipant save(ChatParticipant entity) {
        ChatParticipantJpaEntity jpaEntity = mapper.toJpa(entity);
        ChatParticipantJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatParticipant> findById(ChatParticipantId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatParticipant> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatParticipant entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}