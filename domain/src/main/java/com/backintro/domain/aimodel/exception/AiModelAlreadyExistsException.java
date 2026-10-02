package com.backintro.domain.aimodel.exception;

import com.backintro.domain.common.exception.DomainException;

public class AiModelAlreadyExistsException extends DomainException {
    public AiModelAlreadyExistsException(String message) {
        super(message);
    }
}