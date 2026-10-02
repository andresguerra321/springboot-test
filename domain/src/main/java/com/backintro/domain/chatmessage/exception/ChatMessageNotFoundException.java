package com.backintro.domain.chatmessage.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ChatMessageNotFoundException extends DomainException {
    public ChatMessageNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ChatMessageNotFoundException(String message) {
        super(message);
    }
}