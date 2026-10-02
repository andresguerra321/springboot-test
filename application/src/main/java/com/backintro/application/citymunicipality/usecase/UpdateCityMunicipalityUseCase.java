package com.backintro.application.citymunicipality.usecase;

import com.backintro.application.citymunicipality.command.UpdateCityMunicipalityCommand;
import com.backintro.application.citymunicipality.dto.CityMunicipalityResponse;
import com.backintro.application.citymunicipality.exception.CityMunicipalityNotFoundApplicationException;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;

public class UpdateCityMunicipalityUseCase {
    private final CityMunicipalityRepository repository;
    private final StateRegionRepository stateRegionRepository;

    public UpdateCityMunicipalityUseCase(
            CityMunicipalityRepository repository,
            StateRegionRepository stateRegionRepository
    ) {
        this.repository = repository;
        this.stateRegionRepository = stateRegionRepository;
    }

    public CityMunicipalityResponse execute(UpdateCityMunicipalityCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new CityMunicipalityNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.code(),
                command.name(),
                command.description(),
                command.regionId()
        );

        var updated = repository.save(entity);
        return new CityMunicipalityResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.description(),
                updated.active(),
                updated.regionId(),
                stateRegionRepository.findById(new com.backintro.domain.stateregion.model.valueobject.StateRegionId(updated.regionId())).map(r -> r.name()).orElse(null),
                null,
                null
        );
    }
}