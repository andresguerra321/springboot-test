package com.backintro.domain.contact.exception;

import com.backintro.domain.common.exception.DomainException;

public class ContactAlreadyExistsException extends DomainException {
    public ContactAlreadyExistsException(String message) {
        super(message);
    }
}