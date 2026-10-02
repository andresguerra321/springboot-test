package com.backintro.application.country.usecase;

import com.backintro.application.country.command.UpdateCountryCommand;
import com.backintro.application.country.dto.CountryResponse;
import com.backintro.application.country.exception.CountryNotFoundApplicationException;
import com.backintro.domain.country.exception.CountryAlreadyExistsException;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.domain.country.port.repository.CountryRepository;

import java.util.Objects;

/**
 * Caso de uso: Actualizar los datos de un País existente.
 */
public class UpdateCountryUseCase {

    private final CountryRepository countryRepository;

    public UpdateCountryUseCase(CountryRepository countryRepository) {
        this.countryRepository = Objects.requireNonNull(countryRepository, "CountryRepository no puede ser nulo");
    }

    public CountryResponse execute(UpdateCountryCommand command) {
        if (command == null || command.id() == null) {
            throw new IllegalArgumentException("El comando y el ID no pueden ser nulos");
        }

        CountryId countryId = command.id();
        Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundApplicationException("No se encontró el país con ID: " + countryId.value()));

        String newCode = command.code();
        if (newCode != null && !newCode.trim().isEmpty() && !newCode.equalsIgnoreCase(country.code())) {
            if (countryRepository.existsByCode(newCode.trim())) {
                throw new CountryAlreadyExistsException("Ya existe otro país registrado con el código: " + newCode);
            }
        }

        String nameToUpdate = command.name() != null ? command.name() : country.name();
        String codeToUpdate = newCode != null ? newCode : country.code();

        country.update(nameToUpdate, codeToUpdate);

        Country updated = countryRepository.save(country);
        return new CountryResponse(updated.id().value(), updated.name(), updated.code());
    }
}
