package com.backintro.domain.chatairunerror.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ChatAiRunErrorNotFoundException extends DomainException {
    public ChatAiRunErrorNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ChatAiRunErrorNotFoundException(String message) {
        super(message);
    }
}