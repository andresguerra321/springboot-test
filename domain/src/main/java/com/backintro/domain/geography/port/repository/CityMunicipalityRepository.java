package com.backintro.domain.geography.port.repository;

import com.backintro.domain.geography.model.aggregate.CityMunicipality;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida para el repositorio de CityMunicipality.
 */
public interface CityMunicipalityRepository {

    CityMunicipality save(CityMunicipality city);

    Optional<CityMunicipality> findById(UUID id);

    List<CityMunicipality> findAll();

    List<CityMunicipality> findByRegionId(UUID regionId);

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
