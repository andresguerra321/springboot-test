package com.backintro.application.ports;

import com.backintro.domain.country.model.aggregate.Country;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida para la persistencia de País (Application Output Port).
 */
public interface CountryRepositoryPort {

    Country save(Country country);

    Optional<Country> findById(UUID id);

    List<Country> findAll();

    void deleteById(UUID id);

    boolean existsById(UUID id);

    Optional<Country> findByCode(String codeCountry);
}
