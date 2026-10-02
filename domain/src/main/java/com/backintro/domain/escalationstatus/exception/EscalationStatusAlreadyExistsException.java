package com.backintro.domain.escalationstatus.exception;

import com.backintro.domain.common.exception.DomainException;

public class EscalationStatusAlreadyExistsException extends DomainException {
    public EscalationStatusAlreadyExistsException(String message) {
        super(message);
    }
}