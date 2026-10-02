package com.backintro.domain.diagnosticsystem.exception;

import com.backintro.domain.common.exception.DomainException;

public class DiagnosticSystemAlreadyExistsException extends DomainException {

    public DiagnosticSystemAlreadyExistsException(String message) {
        super(message);
    }
}