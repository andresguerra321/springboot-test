package com.backintro.domain.gender.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class GenderNotFoundException extends DomainException {

    public GenderNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public GenderNotFoundException(String message) {
        super(message);
    }
}