package com.backintro.application.country.exception;

import java.util.UUID;

/**
 * Excepción de aplicación cuando no se encuentra un País.
 */
public class CountryNotFoundApplicationException extends RuntimeException {

    public CountryNotFoundApplicationException(UUID id) {
        super("No se encontró el país con ID: " + id);
    }

    public CountryNotFoundApplicationException(String code) {
        super("No se encontró el país con el código: " + code);
    }
}
