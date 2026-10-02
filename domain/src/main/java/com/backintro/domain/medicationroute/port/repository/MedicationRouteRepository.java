package com.backintro.domain.medicationroute.port.repository;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.medicationroute.model.aggregate.MedicationRoute;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;

public interface MedicationRouteRepository {
    MedicationRoute save(MedicationRoute entity);

    Optional<MedicationRoute> findById(MedicationRouteId id);

    List<MedicationRoute> findAll();

    boolean existsByCode(String code);

    void delete(MedicationRoute entity);
}