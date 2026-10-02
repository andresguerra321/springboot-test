package com.backintro.domain.patientallergy.exception;

import com.backintro.domain.common.exception.DomainException;

public class PatientAllergyAlreadyExistsException extends DomainException {
    public PatientAllergyAlreadyExistsException(String message) {
        super(message);
    }
}