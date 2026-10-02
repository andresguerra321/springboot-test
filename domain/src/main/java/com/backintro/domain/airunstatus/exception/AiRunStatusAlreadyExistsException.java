package com.backintro.domain.airunstatus.exception;

import com.backintro.domain.common.exception.DomainException;

public class AiRunStatusAlreadyExistsException extends DomainException {
    public AiRunStatusAlreadyExistsException(String message) {
        super(message);
    }
}