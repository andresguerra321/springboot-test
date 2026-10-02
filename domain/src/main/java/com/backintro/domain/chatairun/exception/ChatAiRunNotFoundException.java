package com.backintro.domain.chatairun.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ChatAiRunNotFoundException extends DomainException {
    public ChatAiRunNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ChatAiRunNotFoundException(String message) {
        super(message);
    }
}