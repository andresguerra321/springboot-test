package com.backintro.domain.patient.exception;

import com.backintro.domain.common.exception.DomainException;

public class PatientAlreadyExistsException extends DomainException {
    public PatientAlreadyExistsException(String message) {
        super(message);
    }
}