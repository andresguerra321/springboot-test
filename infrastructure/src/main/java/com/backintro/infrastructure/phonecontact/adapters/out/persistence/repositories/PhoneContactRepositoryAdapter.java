package com.backintro.infrastructure.phonecontact.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.phonecontact.model.aggregate.PhoneContact;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.entity.PhoneContactJpaEntity;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.mappers.PhoneContactPersistenceMapper;

public class PhoneContactRepositoryAdapter implements PhoneContactRepository {
    private final PhoneContactJpaRepository jpaRepository;
    private final PhoneContactPersistenceMapper mapper;

    public PhoneContactRepositoryAdapter(PhoneContactJpaRepository jpaRepository, PhoneContactPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public PhoneContact save(PhoneContact entity) {
        PhoneContactJpaEntity jpaEntity = mapper.toJpa(entity);
        PhoneContactJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<PhoneContact> findById(PhoneContactId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<PhoneContact> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(PhoneContact entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}