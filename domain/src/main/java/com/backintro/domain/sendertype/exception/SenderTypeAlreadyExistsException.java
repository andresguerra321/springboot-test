package com.backintro.domain.sendertype.exception;

import com.backintro.domain.common.exception.DomainException;

public class SenderTypeAlreadyExistsException extends DomainException {
    public SenderTypeAlreadyExistsException(String message) {
        super(message);
    }
}