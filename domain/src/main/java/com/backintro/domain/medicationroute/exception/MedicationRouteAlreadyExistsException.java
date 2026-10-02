package com.backintro.domain.medicationroute.exception;

import com.backintro.domain.common.exception.DomainException;

public class MedicationRouteAlreadyExistsException extends DomainException {

    public MedicationRouteAlreadyExistsException(String message) {
        super(message);
    }
}