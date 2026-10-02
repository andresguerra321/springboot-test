package com.backintro.domain.conversationstatus.exception;

import com.backintro.domain.common.exception.DomainException;

public class ConversationStatusAlreadyExistsException extends DomainException {
    public ConversationStatusAlreadyExistsException(String message) {
        super(message);
    }
}