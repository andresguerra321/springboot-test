package com.backintro.application.stateregion.usecase;

import com.backintro.application.stateregion.dto.StateRegionResponse;
import com.backintro.application.stateregion.exception.StateRegionNotFoundApplicationException;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;
import com.backintro.domain.country.port.repository.CountryRepository;

public class GetStateRegionByIdUseCase {
    private final StateRegionRepository repository;
    private final CountryRepository countryRepository;

    public GetStateRegionByIdUseCase(
            StateRegionRepository repository,
            CountryRepository countryRepository
    ) {
        this.repository = repository;
        this.countryRepository = countryRepository;
    }

    public StateRegionResponse execute(StateRegionId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new StateRegionNotFoundApplicationException(id.value().toString()));
        return new StateRegionResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.description(),
                entity.active(),
                entity.countryId(),
                countryRepository.findById(new com.backintro.domain.country.model.valueobject.CountryId(entity.countryId())).map(c -> c.name()).orElse(null),
                null,
                null
        );
    }
}