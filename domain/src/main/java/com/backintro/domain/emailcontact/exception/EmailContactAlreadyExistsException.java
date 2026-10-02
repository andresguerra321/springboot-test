package com.backintro.domain.emailcontact.exception;

import com.backintro.domain.common.exception.DomainException;

public class EmailContactAlreadyExistsException extends DomainException {
    public EmailContactAlreadyExistsException(String message) {
        super(message);
    }
}