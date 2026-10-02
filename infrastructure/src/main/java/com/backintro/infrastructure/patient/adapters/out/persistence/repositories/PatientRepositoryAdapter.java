package com.backintro.infrastructure.patient.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.patient.model.aggregate.Patient;
import com.backintro.domain.patient.model.valueobject.PatientId;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.infrastructure.patient.adapters.out.persistence.entity.PatientJpaEntity;
import com.backintro.infrastructure.patient.adapters.out.persistence.mappers.PatientPersistenceMapper;

public class PatientRepositoryAdapter implements PatientRepository {
    private final PatientJpaRepository jpaRepository;
    private final PatientPersistenceMapper mapper;

    public PatientRepositoryAdapter(PatientJpaRepository jpaRepository, PatientPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Patient save(Patient entity) {
        PatientJpaEntity jpaEntity = mapper.toJpa(entity);
        PatientJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Patient> findById(PatientId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Patient> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Patient entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}