package com.backintro.domain.conversationstatus.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ConversationStatusNotFoundException extends DomainException {
    public ConversationStatusNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ConversationStatusNotFoundException(String message) {
        super(message);
    }
}