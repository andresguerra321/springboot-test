package com.backintro.application.citymunicipality.usecase;

import java.time.LocalDateTime;

import com.backintro.application.citymunicipality.exception.CityMunicipalityNotFoundApplicationException;
import com.backintro.domain.citymunicipality.event.CityMunicipalityDeletedEvent;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class DeleteCityMunicipalityUseCase {
    private final CityMunicipalityRepository repository;

    public DeleteCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        this.repository = repository;
    }

    public CityMunicipalityDeletedEvent execute(CityMunicipalityId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new CityMunicipalityNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new CityMunicipalityDeletedEvent(id, LocalDateTime.now());
    }
}