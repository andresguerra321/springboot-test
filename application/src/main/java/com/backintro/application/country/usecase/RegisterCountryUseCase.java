package com.backintro.application.country.usecase;

import com.backintro.application.country.command.RegisterCountryCommand;
import com.backintro.application.country.dto.CountryResponse;
import com.backintro.domain.country.exception.CountryAlreadyExistsException;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.port.repository.CountryRepository;

import java.util.Objects;

/**
 * Caso de uso: Registrar un nuevo País.
 */
public class RegisterCountryUseCase {

    private final CountryRepository countryRepository;

    public RegisterCountryUseCase(CountryRepository countryRepository) {
        this.countryRepository = Objects.requireNonNull(countryRepository, "CountryRepository no puede ser nulo");
    }

    public CountryResponse execute(RegisterCountryCommand command) {
        if (command == null) {
            throw new IllegalArgumentException("El comando no puede ser nulo");
        }

        String name = command.name();
        String code = command.code();

        if (code != null && !code.trim().isEmpty() && countryRepository.existsByCode(code)) {
            throw new CountryAlreadyExistsException("Ya existe un país registrado con el código: " + code);
        }

        Country newCountry = Country.register(name, code);
        Country saved = countryRepository.save(newCountry);
        return new CountryResponse(saved.id().value(), saved.name(), saved.code());
    }
}
