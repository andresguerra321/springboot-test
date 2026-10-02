package com.backintro.domain.contact.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ContactNotFoundException extends DomainException {
    public ContactNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ContactNotFoundException(String message) {
        super(message);
    }
}