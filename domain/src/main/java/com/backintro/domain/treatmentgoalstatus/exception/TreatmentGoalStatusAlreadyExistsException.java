package com.backintro.domain.treatmentgoalstatus.exception;

import com.backintro.domain.common.exception.DomainException;

public class TreatmentGoalStatusAlreadyExistsException extends DomainException {

    public TreatmentGoalStatusAlreadyExistsException(String message) {
        super(message);
    }
}