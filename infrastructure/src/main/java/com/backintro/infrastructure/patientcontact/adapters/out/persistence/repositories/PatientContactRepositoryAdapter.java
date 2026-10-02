package com.backintro.infrastructure.patientcontact.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.patientcontact.model.aggregate.PatientContact;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.entity.PatientContactJpaEntity;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.mappers.PatientContactPersistenceMapper;

public class PatientContactRepositoryAdapter implements PatientContactRepository {
    private final PatientContactJpaRepository jpaRepository;
    private final PatientContactPersistenceMapper mapper;

    public PatientContactRepositoryAdapter(PatientContactJpaRepository jpaRepository, PatientContactPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public PatientContact save(PatientContact entity) {
        PatientContactJpaEntity jpaEntity = mapper.toJpa(entity);
        PatientContactJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<PatientContact> findById(PatientContactId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<PatientContact> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(PatientContact entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}