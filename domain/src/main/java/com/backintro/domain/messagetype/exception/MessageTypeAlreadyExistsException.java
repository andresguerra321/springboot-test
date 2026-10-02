package com.backintro.domain.messagetype.exception;

import com.backintro.domain.common.exception.DomainException;

public class MessageTypeAlreadyExistsException extends DomainException {
    public MessageTypeAlreadyExistsException(String message) {
        super(message);
    }
}