package com.backintro.domain.messagetype.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class MessageTypeNotFoundException extends DomainException {
    public MessageTypeNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public MessageTypeNotFoundException(String message) {
        super(message);
    }
}