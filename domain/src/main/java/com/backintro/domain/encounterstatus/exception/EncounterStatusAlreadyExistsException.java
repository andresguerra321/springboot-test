package com.backintro.domain.encounterstatus.exception;

import com.backintro.domain.common.exception.DomainException;

public class EncounterStatusAlreadyExistsException extends DomainException {

    public EncounterStatusAlreadyExistsException(String message) {
        super(message);
    }
}