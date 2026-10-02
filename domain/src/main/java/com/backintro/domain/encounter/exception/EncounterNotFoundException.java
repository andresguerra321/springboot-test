package com.backintro.domain.encounter.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class EncounterNotFoundException extends DomainException {
    public EncounterNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public EncounterNotFoundException(String message) {
        super(message);
    }
}