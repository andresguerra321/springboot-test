package com.backintro.domain.professional.exception;

import com.backintro.domain.common.exception.DomainException;

public class ProfessionalAlreadyExistsException extends DomainException {
    public ProfessionalAlreadyExistsException(String message) {
        super(message);
    }
}