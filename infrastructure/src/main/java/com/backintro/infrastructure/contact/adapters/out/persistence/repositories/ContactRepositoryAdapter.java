package com.backintro.infrastructure.contact.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.contact.model.aggregate.Contact;
import com.backintro.domain.contact.model.valueobject.ContactId;
import com.backintro.domain.contact.port.repository.ContactRepository;
import com.backintro.infrastructure.contact.adapters.out.persistence.entity.ContactJpaEntity;
import com.backintro.infrastructure.contact.adapters.out.persistence.mappers.ContactPersistenceMapper;

public class ContactRepositoryAdapter implements ContactRepository {
    private final ContactJpaRepository jpaRepository;
    private final ContactPersistenceMapper mapper;

    public ContactRepositoryAdapter(ContactJpaRepository jpaRepository, ContactPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Contact save(Contact entity) {
        ContactJpaEntity jpaEntity = mapper.toJpa(entity);
        ContactJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Contact> findById(ContactId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Contact> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Contact entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}