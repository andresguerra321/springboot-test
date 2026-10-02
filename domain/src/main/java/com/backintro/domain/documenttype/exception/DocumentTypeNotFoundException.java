package com.backintro.domain.documenttype.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class DocumentTypeNotFoundException extends DomainException {

    public DocumentTypeNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public DocumentTypeNotFoundException(String message) {
        super(message);
    }
}