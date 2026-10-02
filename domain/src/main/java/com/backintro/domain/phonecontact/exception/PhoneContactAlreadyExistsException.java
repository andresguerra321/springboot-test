package com.backintro.domain.phonecontact.exception;

import com.backintro.domain.common.exception.DomainException;

public class PhoneContactAlreadyExistsException extends DomainException {
    public PhoneContactAlreadyExistsException(String message) {
        super(message);
    }
}