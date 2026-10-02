package com.backintro.application.stateregion.usecase;

import java.util.List;

import com.backintro.application.stateregion.dto.StateRegionResponse;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;
import com.backintro.domain.country.port.repository.CountryRepository;

public class ListStateRegionUseCase {
    private final StateRegionRepository repository;
    private final CountryRepository countryRepository;

    public ListStateRegionUseCase(
            StateRegionRepository repository,
            CountryRepository countryRepository
    ) {
        this.repository = repository;
        this.countryRepository = countryRepository;
    }

    public List<StateRegionResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new StateRegionResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.description(),
                entity.active(),
                entity.countryId(),
                countryRepository.findById(new com.backintro.domain.country.model.valueobject.CountryId(entity.countryId())).map(c -> c.name()).orElse(null),
                null,
                null
                ))
                .toList();
    }
}