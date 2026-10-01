package com.backintro.infrastructure.empresa.adapters.out.persistence.repositories;

import com.backintro.infrastructure.empresa.adapters.out.persistence.entity.EmpresaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repositorio Spring Data JPA para la entidad EmpresaJpaEntity.
 */
@Repository
public interface SpringDataEmpresaJpaRepository extends JpaRepository<EmpresaJpaEntity, UUID> {

    Optional<EmpresaJpaEntity> findByNit(String nit);
}
