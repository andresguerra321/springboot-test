package com.backintro.domain.chat.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class ChatNotFoundException extends DomainException {

    public ChatNotFoundException(UUID id) {
        super("Conversación de chat no encontrada con el id: " + id);
    }

    public ChatNotFoundException(String message) {
        super(message);
    }
}
