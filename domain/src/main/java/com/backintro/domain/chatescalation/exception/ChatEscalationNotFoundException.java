package com.backintro.domain.chatescalation.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ChatEscalationNotFoundException extends DomainException {
    public ChatEscalationNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ChatEscalationNotFoundException(String message) {
        super(message);
    }
}