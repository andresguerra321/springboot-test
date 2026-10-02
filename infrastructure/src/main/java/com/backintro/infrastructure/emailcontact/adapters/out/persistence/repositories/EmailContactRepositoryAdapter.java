package com.backintro.infrastructure.emailcontact.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.emailcontact.model.aggregate.EmailContact;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.entity.EmailContactJpaEntity;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.mappers.EmailContactPersistenceMapper;

public class EmailContactRepositoryAdapter implements EmailContactRepository {
    private final EmailContactJpaRepository jpaRepository;
    private final EmailContactPersistenceMapper mapper;

    public EmailContactRepositoryAdapter(EmailContactJpaRepository jpaRepository, EmailContactPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public EmailContact save(EmailContact entity) {
        EmailContactJpaEntity jpaEntity = mapper.toJpa(entity);
        EmailContactJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EmailContact> findById(EmailContactId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<EmailContact> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(EmailContact entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}