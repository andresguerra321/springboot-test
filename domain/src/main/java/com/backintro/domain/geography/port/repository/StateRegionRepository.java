package com.backintro.domain.geography.port.repository;

import com.backintro.domain.geography.model.aggregate.StateRegion;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida para el repositorio de StateRegion.
 */
public interface StateRegionRepository {

    StateRegion save(StateRegion stateRegion);

    Optional<StateRegion> findById(UUID id);

    List<StateRegion> findAll();

    List<StateRegion> findByCountryId(UUID countryId);

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
