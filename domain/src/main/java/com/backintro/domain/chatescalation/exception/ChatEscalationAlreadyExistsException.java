package com.backintro.domain.chatescalation.exception;

import com.backintro.domain.common.exception.DomainException;

public class ChatEscalationAlreadyExistsException extends DomainException {
    public ChatEscalationAlreadyExistsException(String message) {
        super(message);
    }
}