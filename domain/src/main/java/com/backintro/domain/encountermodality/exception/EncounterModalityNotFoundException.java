package com.backintro.domain.encountermodality.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class EncounterModalityNotFoundException extends DomainException {

    public EncounterModalityNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public EncounterModalityNotFoundException(String message) {
        super(message);
    }
}