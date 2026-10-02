package com.backintro.application.citymunicipality.usecase;

import com.backintro.application.citymunicipality.dto.CityMunicipalityResponse;
import com.backintro.application.citymunicipality.exception.CityMunicipalityNotFoundApplicationException;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;

public class GetCityMunicipalityByIdUseCase {
    private final CityMunicipalityRepository repository;
    private final StateRegionRepository stateRegionRepository;

    public GetCityMunicipalityByIdUseCase(
            CityMunicipalityRepository repository,
            StateRegionRepository stateRegionRepository
    ) {
        this.repository = repository;
        this.stateRegionRepository = stateRegionRepository;
    }

    public CityMunicipalityResponse execute(CityMunicipalityId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new CityMunicipalityNotFoundApplicationException(id.value().toString()));
        return new CityMunicipalityResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.description(),
                entity.active(),
                entity.regionId(),
                stateRegionRepository.findById(new com.backintro.domain.stateregion.model.valueobject.StateRegionId(entity.regionId())).map(r -> r.name()).orElse(null),
                null,
                null
        );
    }
}