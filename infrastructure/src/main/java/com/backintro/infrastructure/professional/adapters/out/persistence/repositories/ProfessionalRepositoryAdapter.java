package com.backintro.infrastructure.professional.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.professional.model.aggregate.Professional;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.infrastructure.professional.adapters.out.persistence.entity.ProfessionalJpaEntity;
import com.backintro.infrastructure.professional.adapters.out.persistence.mappers.ProfessionalPersistenceMapper;

public class ProfessionalRepositoryAdapter implements ProfessionalRepository {
    private final ProfessionalJpaRepository jpaRepository;
    private final ProfessionalPersistenceMapper mapper;

    public ProfessionalRepositoryAdapter(ProfessionalJpaRepository jpaRepository, ProfessionalPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Professional save(Professional entity) {
        ProfessionalJpaEntity jpaEntity = mapper.toJpa(entity);
        ProfessionalJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Professional> findById(ProfessionalId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Professional> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Professional entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}