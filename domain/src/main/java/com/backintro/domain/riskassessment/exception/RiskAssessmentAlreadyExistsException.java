package com.backintro.domain.riskassessment.exception;

import com.backintro.domain.common.exception.DomainException;

public class RiskAssessmentAlreadyExistsException extends DomainException {
    public RiskAssessmentAlreadyExistsException(String message) {
        super(message);
    }
}