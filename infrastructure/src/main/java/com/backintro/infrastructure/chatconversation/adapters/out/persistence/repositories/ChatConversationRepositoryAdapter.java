package com.backintro.infrastructure.chatconversation.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatconversation.model.aggregate.ChatConversation;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.entity.ChatConversationJpaEntity;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.mappers.ChatConversationPersistenceMapper;

public class ChatConversationRepositoryAdapter implements ChatConversationRepository {
    private final ChatConversationJpaRepository jpaRepository;
    private final ChatConversationPersistenceMapper mapper;

    public ChatConversationRepositoryAdapter(ChatConversationJpaRepository jpaRepository, ChatConversationPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatConversation save(ChatConversation entity) {
        ChatConversationJpaEntity jpaEntity = mapper.toJpa(entity);
        ChatConversationJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatConversation> findById(ChatConversationId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatConversation> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatConversation entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}