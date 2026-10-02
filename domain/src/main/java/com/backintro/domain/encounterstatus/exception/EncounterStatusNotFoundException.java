package com.backintro.domain.encounterstatus.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class EncounterStatusNotFoundException extends DomainException {

    public EncounterStatusNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public EncounterStatusNotFoundException(String message) {
        super(message);
    }
}