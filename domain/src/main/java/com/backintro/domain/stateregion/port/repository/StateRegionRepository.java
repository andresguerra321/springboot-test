package com.backintro.domain.stateregion.port.repository;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.stateregion.model.aggregate.StateRegion;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;

public interface StateRegionRepository {
    StateRegion save(StateRegion entity);
    Optional<StateRegion> findById(StateRegionId id);
    List<StateRegion> findAll();
    boolean existsByCode(String code);

    void delete(StateRegion entity);
}