package com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.entity.ClinicalRecordJpaEntity;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.mappers.ClinicalRecordPersistenceMapper;

public class ClinicalRecordRepositoryAdapter implements ClinicalRecordRepository {
    private final ClinicalRecordJpaRepository jpaRepository;
    private final ClinicalRecordPersistenceMapper mapper;

    public ClinicalRecordRepositoryAdapter(ClinicalRecordJpaRepository jpaRepository, ClinicalRecordPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ClinicalRecord save(ClinicalRecord entity) {
        ClinicalRecordJpaEntity jpaEntity = mapper.toJpa(entity);
        ClinicalRecordJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ClinicalRecord> findById(ClinicalRecordId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ClinicalRecord> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ClinicalRecord entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}