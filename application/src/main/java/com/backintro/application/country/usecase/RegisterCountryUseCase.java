package com.backintro.application.country.usecase;

import com.backintro.application.country.command.RegisterCountryCommand;
import com.backintro.application.country.dto.CountryResponse;
import com.backintro.domain.country.exception.CountryAlreadyExistsException;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryCode;
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

        if (command.getCodeCountry() != null && !command.getCodeCountry().trim().isEmpty()) {
            CountryCode code = new CountryCode(command.getCodeCountry());
            if (countryRepository.findByCode(code).isPresent()) {
                throw new CountryAlreadyExistsException("Ya existe un país registrado con el código: " + command.getCodeCountry());
            }
        }

        Country newCountry = Country.create(
                command.getNameCountry(),
                command.getCodeCountry(),
                command.getDescription(),
                command.getTelephonePrefix()
        );

        Country saved = countryRepository.save(newCountry);
        return CountryResponse.fromDomain(saved);
    }
}
