package com.backintro.domain.sendertype.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class SenderTypeNotFoundException extends DomainException {
    public SenderTypeNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public SenderTypeNotFoundException(String message) {
        super(message);
    }
}