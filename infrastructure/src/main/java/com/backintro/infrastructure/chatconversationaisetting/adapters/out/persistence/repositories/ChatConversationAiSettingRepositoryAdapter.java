package com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;
import com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.entity.ChatConversationAiSettingJpaEntity;
import com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.mappers.ChatConversationAiSettingPersistenceMapper;

public class ChatConversationAiSettingRepositoryAdapter implements ChatConversationAiSettingRepository {
    private final ChatConversationAiSettingJpaRepository jpaRepository;
    private final ChatConversationAiSettingPersistenceMapper mapper;

    public ChatConversationAiSettingRepositoryAdapter(ChatConversationAiSettingJpaRepository jpaRepository, ChatConversationAiSettingPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatConversationAiSetting save(ChatConversationAiSetting entity) {
        ChatConversationAiSettingJpaEntity jpaEntity = mapper.toJpa(entity);
        ChatConversationAiSettingJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatConversationAiSetting> findById(ChatConversationAiSettingId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatConversationAiSetting> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatConversationAiSetting entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}