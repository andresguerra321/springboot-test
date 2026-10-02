package com.backintro.domain.encountertype.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class EncounterTypeNotFoundException extends DomainException {

    public EncounterTypeNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public EncounterTypeNotFoundException(String message) {
        super(message);
    }
}