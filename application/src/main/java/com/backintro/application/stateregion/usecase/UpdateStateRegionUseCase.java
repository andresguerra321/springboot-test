package com.backintro.application.stateregion.usecase;

import com.backintro.application.stateregion.command.UpdateStateRegionCommand;
import com.backintro.application.stateregion.dto.StateRegionResponse;
import com.backintro.application.stateregion.exception.StateRegionNotFoundApplicationException;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;
import com.backintro.domain.country.port.repository.CountryRepository;

public class UpdateStateRegionUseCase {
    private final StateRegionRepository repository;
    private final CountryRepository countryRepository;

    public UpdateStateRegionUseCase(
            StateRegionRepository repository,
            CountryRepository countryRepository
    ) {
        this.repository = repository;
        this.countryRepository = countryRepository;
    }

    public StateRegionResponse execute(UpdateStateRegionCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new StateRegionNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.code(),
                command.name(),
                command.description(),
                command.countryId()
        );

        var updated = repository.save(entity);
        return new StateRegionResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.description(),
                updated.active(),
                updated.countryId(),
                countryRepository.findById(new com.backintro.domain.country.model.valueobject.CountryId(updated.countryId())).map(c -> c.name()).orElse(null),
                null,
                null
        );
    }
}