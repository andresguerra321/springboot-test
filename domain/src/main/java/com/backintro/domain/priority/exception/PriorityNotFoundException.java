package com.backintro.domain.priority.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class PriorityNotFoundException extends DomainException {
    public PriorityNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public PriorityNotFoundException(String message) {
        super(message);
    }
}