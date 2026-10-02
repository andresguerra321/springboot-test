package com.backintro.domain.airunstatus.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class AiRunStatusNotFoundException extends DomainException {
    public AiRunStatusNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public AiRunStatusNotFoundException(String message) {
        super(message);
    }
}