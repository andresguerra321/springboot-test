package com.backintro.domain.consenttype.exception;

import com.backintro.domain.common.exception.DomainException;

public class ConsentTypeAlreadyExistsException extends DomainException {

    public ConsentTypeAlreadyExistsException(String message) {
        super(message);
    }
}