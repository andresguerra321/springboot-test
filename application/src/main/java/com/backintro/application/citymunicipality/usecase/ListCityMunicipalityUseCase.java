package com.backintro.application.citymunicipality.usecase;

import java.util.List;

import com.backintro.application.citymunicipality.dto.CityMunicipalityResponse;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;

public class ListCityMunicipalityUseCase {
    private final CityMunicipalityRepository repository;
    private final StateRegionRepository stateRegionRepository;

    public ListCityMunicipalityUseCase(
            CityMunicipalityRepository repository,
            StateRegionRepository stateRegionRepository
    ) {
        this.repository = repository;
        this.stateRegionRepository = stateRegionRepository;
    }

    public List<CityMunicipalityResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new CityMunicipalityResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.description(),
                entity.active(),
                entity.regionId(),
                stateRegionRepository.findById(new com.backintro.domain.stateregion.model.valueobject.StateRegionId(entity.regionId())).map(r -> r.name()).orElse(null),
                null,
                null
                ))
                .toList();
    }
}