package com.backintro.domain.aimodel.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class AiModelNotFoundException extends DomainException {
    public AiModelNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public AiModelNotFoundException(String message) {
        super(message);
    }
}