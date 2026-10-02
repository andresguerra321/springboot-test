package com.backintro.domain.risklevel.exception;

import com.backintro.domain.common.exception.DomainException;

public class RiskLevelAlreadyExistsException extends DomainException {

    public RiskLevelAlreadyExistsException(String message) {
        super(message);
    }
}