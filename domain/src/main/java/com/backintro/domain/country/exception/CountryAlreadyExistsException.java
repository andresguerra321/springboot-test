package com.backintro.domain.country.exception;

import com.backintro.domain.common.exception.DomainException;

/**
 * Excepción lanzada cuando ya existe un País con el mismo código o nombre.
 */
public class CountryAlreadyExistsException extends DomainException {

    public CountryAlreadyExistsException(String message) {
        super(message);
    }
}
