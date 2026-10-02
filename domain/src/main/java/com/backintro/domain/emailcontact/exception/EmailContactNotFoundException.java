package com.backintro.domain.emailcontact.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class EmailContactNotFoundException extends DomainException {
    public EmailContactNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public EmailContactNotFoundException(String message) {
        super(message);
    }
}