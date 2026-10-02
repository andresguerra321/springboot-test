package com.backintro.domain.stateregion.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class StateRegionNotFoundException extends DomainException {
    public StateRegionNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public StateRegionNotFoundException(String message) {
        super(message);
    }
}