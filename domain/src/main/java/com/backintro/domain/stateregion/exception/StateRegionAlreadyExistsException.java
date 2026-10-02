package com.backintro.domain.stateregion.exception;

import com.backintro.domain.common.exception.DomainException;

public class StateRegionAlreadyExistsException extends DomainException {
    public StateRegionAlreadyExistsException(String message) {
        super(message);
    }
}