package com.backintro.domain.phonecontact.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class PhoneContactNotFoundException extends DomainException {
    public PhoneContactNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public PhoneContactNotFoundException(String message) {
        super(message);
    }
}