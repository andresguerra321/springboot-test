package com.backintro.domain.empresa.port.repository;

import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.model.valueobject.Nit;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida para el repositorio de Empresa (Domain Repository Port).
 */
public interface EmpresaRepository {

    Empresa save(Empresa empresa);

    Optional<Empresa> findById(UUID id);

    Optional<Empresa> findByNit(Nit nit);

    List<Empresa> findAll();

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
