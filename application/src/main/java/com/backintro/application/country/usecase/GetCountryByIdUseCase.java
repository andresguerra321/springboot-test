package com.backintro.application.country.usecase;

import com.backintro.application.country.dto.CountryResponse;
import com.backintro.application.country.exception.CountryNotFoundApplicationException;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.domain.country.port.repository.CountryRepository;

import java.util.Objects;
import java.util.UUID;

/**
 * Caso de uso: Consultar un País por su ID.
 */
public class GetCountryByIdUseCase {

    private final CountryRepository countryRepository;

    public GetCountryByIdUseCase(CountryRepository countryRepository) {
        this.countryRepository = Objects.requireNonNull(countryRepository, "CountryRepository no puede ser nulo");
    }

    public CountryResponse execute(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }

        Country country = countryRepository.findById(new CountryId(id))
                .orElseThrow(() -> new CountryNotFoundApplicationException("No se encontró el país con ID: " + id));

        return new CountryResponse(country.id().value(), country.name(), country.code());
    }
}
