package com.backintro.domain.consenttype.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class ConsentTypeNotFoundException extends DomainException {

    public ConsentTypeNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public ConsentTypeNotFoundException(String message) {
        super(message);
    }
}