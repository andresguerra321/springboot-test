package com.backintro.domain.encountermodality.exception;

import com.backintro.domain.common.exception.DomainException;

public class EncounterModalityAlreadyExistsException extends DomainException {

    public EncounterModalityAlreadyExistsException(String message) {
        super(message);
    }
}