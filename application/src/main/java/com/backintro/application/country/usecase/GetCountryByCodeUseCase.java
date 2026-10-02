package com.backintro.application.country.usecase;

import com.backintro.application.country.dto.CountryResponse;
import com.backintro.application.country.exception.CountryNotFoundApplicationException;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.port.repository.CountryRepository;

import java.util.Objects;

/**
 * Caso de uso: Consultar un País por su código alfanumérico/ISO.
 */
public class GetCountryByCodeUseCase {

    private final CountryRepository countryRepository;

    public GetCountryByCodeUseCase(CountryRepository countryRepository) {
        this.countryRepository = Objects.requireNonNull(countryRepository, "CountryRepository no puede ser nulo");
    }

    public CountryResponse execute(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de país no puede ser nulo ni vacío");
        }

        Country country = countryRepository.findByCode(code.trim())
                .orElseThrow(() -> new CountryNotFoundApplicationException(code));

        return CountryResponse.fromDomain(country);
    }
}
