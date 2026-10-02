package com.backintro.application.country.usecase;

import com.backintro.application.country.exception.CountryNotFoundApplicationException;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.domain.country.port.repository.CountryRepository;

import java.util.Objects;
import java.util.UUID;

/**
 * Caso de uso: Eliminar un País por su ID.
 */
public class DeleteCountryUseCase {

    private final CountryRepository countryRepository;

    public DeleteCountryUseCase(CountryRepository countryRepository) {
        this.countryRepository = Objects.requireNonNull(countryRepository, "CountryRepository no puede ser nulo");
    }

    public void execute(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }

        CountryId countryId = new CountryId(id);
        Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundApplicationException(id));

        countryRepository.delete(country);
    }
}
