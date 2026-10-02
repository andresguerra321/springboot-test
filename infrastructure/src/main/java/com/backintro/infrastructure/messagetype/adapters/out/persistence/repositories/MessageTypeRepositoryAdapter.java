package com.backintro.infrastructure.messagetype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.messagetype.model.aggregate.MessageType;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;
import com.backintro.infrastructure.messagetype.adapters.out.persistence.entity.MessageTypeJpaEntity;
import com.backintro.infrastructure.messagetype.adapters.out.persistence.mappers.MessageTypePersistenceMapper;

public class MessageTypeRepositoryAdapter implements MessageTypeRepository {
    private final MessageTypeJpaRepository jpaRepository;
    private final MessageTypePersistenceMapper mapper;

    public MessageTypeRepositoryAdapter(MessageTypeJpaRepository jpaRepository, MessageTypePersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public MessageType save(MessageType entity) {
        MessageTypeJpaEntity jpaEntity = mapper.toJpa(entity);
        MessageTypeJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<MessageType> findById(MessageTypeId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<MessageType> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(MessageType entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}