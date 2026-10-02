package com.backintro.domain.ai.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class AiRunNotFoundException extends DomainException {

    public AiRunNotFoundException(UUID id) {
        super("Ejecución de IA no encontrada con el id: " + id);
    }

    public AiRunNotFoundException(String message) {
        super(message);
    }
}
