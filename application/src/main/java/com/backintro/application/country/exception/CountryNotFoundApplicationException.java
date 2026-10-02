package com.backintro.application.country.exception;

import com.backintro.application.common.ApplicationException;

import java.util.UUID;

/**
 * Excepción de aplicación cuando no se encuentra un País.
 */
public class CountryNotFoundApplicationException extends ApplicationException {

    public CountryNotFoundApplicationException(UUID id) {
        super("No se encontró el país con ID: " + id);
    }

    public CountryNotFoundApplicationException(String code) {
        super("No se encontró el país con el código: " + code);
    }
}
