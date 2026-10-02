package com.backintro.domain.treatmentgoal.exception;

import com.backintro.domain.common.exception.DomainException;

public class TreatmentGoalAlreadyExistsException extends DomainException {
    public TreatmentGoalAlreadyExistsException(String message) {
        super(message);
    }
}