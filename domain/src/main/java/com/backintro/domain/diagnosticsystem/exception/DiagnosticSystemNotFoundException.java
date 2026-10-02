package com.backintro.domain.diagnosticsystem.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class DiagnosticSystemNotFoundException extends DomainException {

    public DiagnosticSystemNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public DiagnosticSystemNotFoundException(String message) {
        super(message);
    }
}