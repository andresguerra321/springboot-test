package com.backintro.domain.patientcontact.exception;

import com.backintro.domain.common.exception.DomainException;

public class PatientContactAlreadyExistsException extends DomainException {
    public PatientContactAlreadyExistsException(String message) {
        super(message);
    }
}