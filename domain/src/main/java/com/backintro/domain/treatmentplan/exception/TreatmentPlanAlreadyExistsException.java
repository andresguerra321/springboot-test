package com.backintro.domain.treatmentplan.exception;

import com.backintro.domain.common.exception.DomainException;

public class TreatmentPlanAlreadyExistsException extends DomainException {
    public TreatmentPlanAlreadyExistsException(String message) {
        super(message);
    }
}