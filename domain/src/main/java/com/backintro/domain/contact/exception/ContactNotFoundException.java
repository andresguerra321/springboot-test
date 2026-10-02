package com.backintro.domain.contact.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

/**
 * Excepción lanzada cuando no se encuentra un Contacto.
 */
public class ContactNotFoundException extends DomainException {

    public ContactNotFoundException(UUID id) {
        super("No se encontró el contacto con el identificador: " + id);
    }
}
