package com.backintro.domain.encounter.exception;

import com.backintro.domain.common.exception.DomainException;

public class EncounterAlreadyExistsException extends DomainException {
    public EncounterAlreadyExistsException(String message) {
        super(message);
    }
}