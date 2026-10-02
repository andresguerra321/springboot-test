package com.backintro.application.country.usecase;

import com.backintro.application.country.command.UpdateCountryCommand;
import com.backintro.application.country.dto.CountryResponse;
import com.backintro.application.country.exception.CountryNotFoundApplicationException;
import com.backintro.domain.country.port.repository.CountryRepository;

public class UpdateCountryUseCase {
    private final CountryRepository repository;


    public UpdateCountryUseCase(
            CountryRepository repository
    ) {
        this.repository = repository;
    }

    public CountryResponse execute(UpdateCountryCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new CountryNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.code(),
                command.name(),
                command.description(),
                command.telephonePrefix()
        );

        var updated = repository.save(entity);
        return new CountryResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.description(),
                updated.active(),
                updated.telephonePrefix(),
                null,
                null
        );
    }
}