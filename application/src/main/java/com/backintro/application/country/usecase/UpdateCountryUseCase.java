package com.backintro.application.country.usecase;

import com.backintro.application.country.command.UpdateCountryCommand;
import com.backintro.application.country.dto.CountryResponse;
import com.backintro.application.country.exception.CountryNotFoundApplicationException;
import com.backintro.domain.country.exception.CountryAlreadyExistsException;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryCode;
import com.backintro.domain.country.port.repository.CountryRepository;

import java.util.Objects;
import java.util.Optional;

/**
 * Caso de uso: Actualizar los datos de un País existente.
 */
public class UpdateCountryUseCase {

    private final CountryRepository countryRepository;

    public UpdateCountryUseCase(CountryRepository countryRepository) {
        this.countryRepository = Objects.requireNonNull(countryRepository, "CountryRepository no puede ser nulo");
    }

    public CountryResponse execute(UpdateCountryCommand command) {
        if (command == null || command.getId() == null) {
            throw new IllegalArgumentException("El comando y el ID no pueden ser nulos");
        }

        Country country = countryRepository.findById(command.getId())
                .orElseThrow(() -> new CountryNotFoundApplicationException(command.getId()));

        if (command.getCodeCountry() != null && !command.getCodeCountry().trim().isEmpty()) {
            CountryCode newCode = new CountryCode(command.getCodeCountry());
            Optional<Country> existingWithCode = countryRepository.findByCode(newCode);
            if (existingWithCode.isPresent() && !existingWithCode.get().getId().equals(country.getId())) {
                throw new CountryAlreadyExistsException("Ya existe otro país registrado con el código: " + command.getCodeCountry());
            }
        }

        country.update(
                command.getNameCountry(),
                command.getCodeCountry(),
                command.getDescription(),
                command.getTelephonePrefix(),
                command.getIsActive()
        );

        Country updated = countryRepository.save(country);
        return CountryResponse.fromDomain(updated);
    }
}
