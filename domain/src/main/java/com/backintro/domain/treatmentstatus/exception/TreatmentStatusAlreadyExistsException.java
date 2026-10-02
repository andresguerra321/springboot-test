package com.backintro.domain.treatmentstatus.exception;

import com.backintro.domain.common.exception.DomainException;

public class TreatmentStatusAlreadyExistsException extends DomainException {

    public TreatmentStatusAlreadyExistsException(String message) {
        super(message);
    }
}