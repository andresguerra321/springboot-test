package com.backintro.infrastructure.chatmessage.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatmessage.model.aggregate.ChatMessage;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;
import com.backintro.infrastructure.chatmessage.adapters.out.persistence.entity.ChatMessageJpaEntity;
import com.backintro.infrastructure.chatmessage.adapters.out.persistence.mappers.ChatMessagePersistenceMapper;

public class ChatMessageRepositoryAdapter implements ChatMessageRepository {
    private final ChatMessageJpaRepository jpaRepository;
    private final ChatMessagePersistenceMapper mapper;

    public ChatMessageRepositoryAdapter(ChatMessageJpaRepository jpaRepository, ChatMessagePersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatMessage save(ChatMessage entity) {
        ChatMessageJpaEntity jpaEntity = mapper.toJpa(entity);
        ChatMessageJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatMessage> findById(ChatMessageId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatMessage> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatMessage entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}