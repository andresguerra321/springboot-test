package com.backintro.domain.priority.exception;

import com.backintro.domain.common.exception.DomainException;

public class PriorityAlreadyExistsException extends DomainException {
    public PriorityAlreadyExistsException(String message) {
        super(message);
    }
}