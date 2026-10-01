package com.backintro.domain.country.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

/**
 * Excepción lanzada cuando no se encuentra un País.
 */
public class CountryNotFoundException extends DomainException {

    public CountryNotFoundException(UUID id) {
        super("No se encontró el país con el identificador: " + id);
    }

    public CountryNotFoundException(String message) {
        super(message);
    }
}
