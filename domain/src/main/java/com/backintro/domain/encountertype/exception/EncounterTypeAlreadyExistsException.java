package com.backintro.domain.encountertype.exception;

import com.backintro.domain.common.exception.DomainException;

public class EncounterTypeAlreadyExistsException extends DomainException {

    public EncounterTypeAlreadyExistsException(String message) {
        super(message);
    }
}