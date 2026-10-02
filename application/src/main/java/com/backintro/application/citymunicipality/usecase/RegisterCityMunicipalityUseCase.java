package com.backintro.application.citymunicipality.usecase;

import com.backintro.application.citymunicipality.command.RegisterCityMunicipalityCommand;
import com.backintro.application.citymunicipality.dto.CityMunicipalityResponse;
import com.backintro.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;

public class RegisterCityMunicipalityUseCase {
    private final CityMunicipalityRepository repository;
    private final StateRegionRepository stateRegionRepository;

    public RegisterCityMunicipalityUseCase(
            CityMunicipalityRepository repository,
            StateRegionRepository stateRegionRepository
    ) {
        this.repository = repository;
        this.stateRegionRepository = stateRegionRepository;
    }

    public CityMunicipalityResponse execute(RegisterCityMunicipalityCommand command) {
        CityMunicipality entity = CityMunicipality.register(
                command.code(),
                command.name(),
                command.description(),
                command.regionId()
        );
        CityMunicipality saved = repository.save(entity);
        return new CityMunicipalityResponse(
                saved.id().value(),
                saved.code(),
                saved.name(),
                saved.description(),
                saved.active(),
                saved.regionId(),
                stateRegionRepository.findById(new com.backintro.domain.stateregion.model.valueobject.StateRegionId(saved.regionId())).map(r -> r.name()).orElse(null),
                null,
                null
        );
    }
}