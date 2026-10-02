package com.backintro.domain.professionaltype.exception;

import com.backintro.domain.common.exception.DomainException;

public class ProfessionalTypeAlreadyExistsException extends DomainException {

    public ProfessionalTypeAlreadyExistsException(String message) {
        super(message);
    }
}