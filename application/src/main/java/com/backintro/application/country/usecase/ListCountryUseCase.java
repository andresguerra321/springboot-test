package com.backintro.application.country.usecase;

import com.backintro.application.country.dto.CountryResponse;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.port.repository.CountryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Caso de uso: Listar todos los Países registrados.
 */
public class ListCountryUseCase {

    private final CountryRepository countryRepository;

    public ListCountryUseCase(CountryRepository countryRepository) {
        this.countryRepository = Objects.requireNonNull(countryRepository, "CountryRepository no puede ser nulo");
    }

    public List<CountryResponse> execute() {
        List<Country> countries = countryRepository.findAll();
        List<CountryResponse> responses = new ArrayList<>(countries.size());

        for (Country country : countries) {
            responses.add(new CountryResponse(country.id().value(), country.name(), country.code()));
        }

        return responses;
    }
}
