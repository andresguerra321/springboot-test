package com.backintro.infrastructure.professionaltype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.professionaltype.model.aggregate.ProfessionalType;
import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository;
import com.backintro.infrastructure.professionaltype.adapters.out.persistence.entity.ProfessionalTypeJpaEntity;
import com.backintro.infrastructure.professionaltype.adapters.out.persistence.mappers.ProfessionalTypePersistenceMapper;

public class ProfessionalTypeRepositoryAdapter implements ProfessionalTypeRepository {

    private final ProfessionalTypeJpaRepository jpaRepository;
    private final ProfessionalTypePersistenceMapper mapper;

    public ProfessionalTypeRepositoryAdapter(
            ProfessionalTypeJpaRepository jpaRepository,
            ProfessionalTypePersistenceMapper mapper
    ) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ProfessionalType save(ProfessionalType entity) {
        ProfessionalTypeJpaEntity jpaEntity = mapper.toJpa(entity);
        ProfessionalTypeJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ProfessionalType> findById(ProfessionalTypeId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ProfessionalType> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ProfessionalType entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}