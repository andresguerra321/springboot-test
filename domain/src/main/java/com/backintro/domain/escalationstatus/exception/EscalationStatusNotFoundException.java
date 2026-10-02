package com.backintro.domain.escalationstatus.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class EscalationStatusNotFoundException extends DomainException {
    public EscalationStatusNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public EscalationStatusNotFoundException(String message) {
        super(message);
    }
}