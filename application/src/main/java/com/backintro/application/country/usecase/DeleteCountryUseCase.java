package com.backintro.application.country.usecase;

import java.time.LocalDateTime;

import com.backintro.application.country.exception.CountryNotFoundApplicationException;
import com.backintro.domain.country.event.CountryDeletedEvent;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.domain.country.port.repository.CountryRepository;

public class DeleteCountryUseCase {
    private final CountryRepository repository;

    public DeleteCountryUseCase(CountryRepository repository) {
        this.repository = repository;
    }

    public CountryDeletedEvent execute(CountryId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new CountryNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new CountryDeletedEvent(id, LocalDateTime.now());
    }
}