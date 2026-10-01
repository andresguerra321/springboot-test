package com.backintro.infrastructure.empresa.adapters.out.persistence.repositories;

import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.model.valueobject.Nit;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;
import com.backintro.infrastructure.empresa.adapters.out.persistence.entity.EmpresaJpaEntity;
import com.backintro.infrastructure.empresa.adapters.out.persistence.mappers.EmpresaPersistenceMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Adaptador de persistencia que implementa el puerto EmpresaRepository
 * delegando en SpringDataEmpresaJpaRepository y mapeando con EmpresaPersistenceMapper.
 */
@Component
public class EmpresaRepositoryAdapter implements EmpresaRepository {

    private final SpringDataEmpresaJpaRepository springDataRepository;
    private final EmpresaPersistenceMapper mapper;

    public EmpresaRepositoryAdapter(SpringDataEmpresaJpaRepository springDataRepository,
                                    EmpresaPersistenceMapper mapper) {
        this.springDataRepository = Objects.requireNonNull(springDataRepository, "SpringDataRepository no puede ser nulo");
        this.mapper = Objects.requireNonNull(mapper, "EmpresaPersistenceMapper no puede ser nulo");
    }

    @Override
    public Empresa save(Empresa empresa) {
        if (empresa == null) {
            throw new IllegalArgumentException("La empresa no puede ser nula");
        }
        EmpresaJpaEntity jpaEntity = mapper.toJpaEntity(empresa);
        EmpresaJpaEntity savedEntity = springDataRepository.save(jpaEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Empresa> findById(UUID id) {
        if (id == null) {
            return Optional.empty();
        }
        return springDataRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Empresa> findByNit(Nit nit) {
        if (nit == null || nit.getValue() == null) {
            return Optional.empty();
        }
        return springDataRepository.findByNit(nit.getValue()).map(mapper::toDomain);
    }

    @Override
    public List<Empresa> findAll() {
        List<EmpresaJpaEntity> entities = springDataRepository.findAll();
        List<Empresa> domainList = new ArrayList<>(entities.size());
        for (EmpresaJpaEntity entity : entities) {
            domainList.add(mapper.toDomain(entity));
        }
        return domainList;
    }

    @Override
    public void deleteById(UUID id) {
        if (id != null) {
            springDataRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        if (id == null) {
            return false;
        }
        return springDataRepository.existsById(id);
    }
}
