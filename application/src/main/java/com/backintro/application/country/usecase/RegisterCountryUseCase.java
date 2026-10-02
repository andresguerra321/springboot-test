package com.backintro.application.country.usecase;

import com.backintro.application.country.command.RegisterCountryCommand;
import com.backintro.application.country.dto.CountryResponse;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.port.repository.CountryRepository;

public class RegisterCountryUseCase {
    private final CountryRepository repository;


    public RegisterCountryUseCase(
            CountryRepository repository
    ) {
        this.repository = repository;
    }

    public CountryResponse execute(RegisterCountryCommand command) {
        Country entity = Country.register(
                command.code(),
                command.name(),
                command.description(),
                command.telephonePrefix()
        );
        Country saved = repository.save(entity);
        return new CountryResponse(
                saved.id().value(),
                saved.code(),
                saved.name(),
                saved.description(),
                saved.active(),
                saved.telephonePrefix(),
                null,
                null
        );
    }
}