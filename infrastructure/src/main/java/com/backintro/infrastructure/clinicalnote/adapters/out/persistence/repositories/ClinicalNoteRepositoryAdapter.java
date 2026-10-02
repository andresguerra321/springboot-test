package com.backintro.infrastructure.clinicalnote.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.clinicalnote.model.aggregate.ClinicalNote;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;
import com.backintro.infrastructure.clinicalnote.adapters.out.persistence.entity.ClinicalNoteJpaEntity;
import com.backintro.infrastructure.clinicalnote.adapters.out.persistence.mappers.ClinicalNotePersistenceMapper;

public class ClinicalNoteRepositoryAdapter implements ClinicalNoteRepository {
    private final ClinicalNoteJpaRepository jpaRepository;
    private final ClinicalNotePersistenceMapper mapper;

    public ClinicalNoteRepositoryAdapter(ClinicalNoteJpaRepository jpaRepository, ClinicalNotePersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ClinicalNote save(ClinicalNote entity) {
        ClinicalNoteJpaEntity jpaEntity = mapper.toJpa(entity);
        ClinicalNoteJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ClinicalNote> findById(ClinicalNoteId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ClinicalNote> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ClinicalNote entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}