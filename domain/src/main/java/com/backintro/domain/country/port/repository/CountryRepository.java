package com.backintro.domain.country.port.repository;

import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para el repositorio de Country (Domain Repository Port).
 */
public interface CountryRepository {

    Country save(Country country);

    Optional<Country> findById(CountryId id);

    Optional<Country> findByCode(String code);

    List<Country> findAll();

    void deleteById(CountryId id);

    boolean existsById(CountryId id);

    boolean existsByCode(String code);
}
