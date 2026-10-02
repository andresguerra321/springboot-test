package com.backintro.domain.catalog.port.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interfaz genérica para repositorios de catálogos paramétricos.
 * Evita duplicar la misma interfaz para cada tabla de lookup.
 *
 * @param <T> Tipo de entidad del catálogo.
 */
public interface CatalogRepository<T> {

    T save(T entity);

    Optional<T> findById(UUID id);

    Optional<T> findByCode(String code);

    List<T> findAll();

    List<T> findAllActive();

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
