package com.backintro.domain.country.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class CountryNotFoundException extends DomainException {
    public CountryNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public CountryNotFoundException(String message) {
        super(message);
    }
}