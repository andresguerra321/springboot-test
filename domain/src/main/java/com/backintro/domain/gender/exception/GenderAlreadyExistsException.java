package com.backintro.domain.gender.exception;

import com.backintro.domain.common.exception.DomainException;

public class GenderAlreadyExistsException extends DomainException {

    public GenderAlreadyExistsException(String message) {
        super(message);
    }
}