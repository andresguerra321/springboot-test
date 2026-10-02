package com.backintro.infrastructure.professionalstudy.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.professionalstudy.model.aggregate.ProfessionalStudy;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.entity.ProfessionalStudyJpaEntity;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.mappers.ProfessionalStudyPersistenceMapper;

public class ProfessionalStudyRepositoryAdapter implements ProfessionalStudyRepository {
    private final ProfessionalStudyJpaRepository jpaRepository;
    private final ProfessionalStudyPersistenceMapper mapper;

    public ProfessionalStudyRepositoryAdapter(ProfessionalStudyJpaRepository jpaRepository, ProfessionalStudyPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ProfessionalStudy save(ProfessionalStudy entity) {
        ProfessionalStudyJpaEntity jpaEntity = mapper.toJpa(entity);
        ProfessionalStudyJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ProfessionalStudy> findById(ProfessionalStudyId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ProfessionalStudy> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ProfessionalStudy entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}