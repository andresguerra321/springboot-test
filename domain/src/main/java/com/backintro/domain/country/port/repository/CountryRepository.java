package com.backintro.domain.country.port.repository;

import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryCode;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida para el repositorio de Country (Domain Repository Port).
 */
public interface CountryRepository {

    Country save(Country country);

    Optional<Country> findById(UUID id);

    Optional<Country> findByCode(CountryCode codeCountry);

    List<Country> findAll();

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
