package com.backintro.application.country.usecase;

import com.backintro.application.country.dto.CountryResponse;
import com.backintro.application.country.exception.CountryNotFoundApplicationException;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.domain.country.port.repository.CountryRepository;

public class GetCountryByIdUseCase {
    private final CountryRepository repository;


    public GetCountryByIdUseCase(
            CountryRepository repository
    ) {
        this.repository = repository;
    }

    public CountryResponse execute(CountryId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new CountryNotFoundApplicationException(id.value().toString()));
        return new CountryResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.description(),
                entity.active(),
                entity.telephonePrefix(),
                null,
                null
        );
    }
}