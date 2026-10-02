package com.backintro.application.stateregion.usecase;

import com.backintro.application.stateregion.command.RegisterStateRegionCommand;
import com.backintro.application.stateregion.dto.StateRegionResponse;
import com.backintro.domain.stateregion.model.aggregate.StateRegion;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;
import com.backintro.domain.country.port.repository.CountryRepository;

public class RegisterStateRegionUseCase {
    private final StateRegionRepository repository;
    private final CountryRepository countryRepository;

    public RegisterStateRegionUseCase(
            StateRegionRepository repository,
            CountryRepository countryRepository
    ) {
        this.repository = repository;
        this.countryRepository = countryRepository;
    }

    public StateRegionResponse execute(RegisterStateRegionCommand command) {
        StateRegion entity = StateRegion.register(
                command.code(),
                command.name(),
                command.description(),
                command.countryId()
        );
        StateRegion saved = repository.save(entity);
        return new StateRegionResponse(
                saved.id().value(),
                saved.code(),
                saved.name(),
                saved.description(),
                saved.active(),
                saved.countryId(),
                countryRepository.findById(new com.backintro.domain.country.model.valueobject.CountryId(saved.countryId())).map(c -> c.name()).orElse(null),
                null,
                null
        );
    }
}